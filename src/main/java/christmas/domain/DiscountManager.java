package christmas.domain;

import christmas.Date;
import christmas.Order;
import christmas.enums.Calendar;
import christmas.enums.Discount;
import christmas.enums.Menu;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class DiscountManager implements DiscountService {
    private final Counter counter;
    private static final DayOfWeek SPECIAL_DAY = DayOfWeek.SUNDAY;
    private static final int CHRISTMAS_DAY = 25;

    public DiscountManager(Counter counter) {
        this.counter = counter;
    }

    @Override
    public boolean isGift(int price) {
        if (price >= Discount.GIFT_PRICE.getPrice()) {
            return true;
        }
        return false;
    }

    @Override
    public int christmasDDay(Date date) {
        if (date.getInputDay() > Calendar.getChristmasDDayEventEndDay()
                || date.getInputDay() < Calendar.getChristmasDDayEventStartDay()) {
            return 0;
        }
        return Discount.CHRISTMAS_D_DAY_START_PRICE.getPrice()
                + Discount.CHRISTMAS_D_DAY_INCREASE_PRICE.getPrice() * (date.getInputDay() - 1);
    }

    @Override
    public int weekday(Date date, Order order) {
        LocalDate specificDate = LocalDate.of(Calendar.getThisYear(), date.getCalendar().getMonth(), date.getInputDay());
        DayOfWeek dayOfWeek = specificDate.getDayOfWeek();
        Map<Menu, Integer> menus = new HashMap<>();
        boolean isWeekday = dayOfWeek != DayOfWeek.SATURDAY && dayOfWeek != DayOfWeek.SUNDAY;
        int quantityOfDessert = counter.countDessert(menus);

        if (isWeekday) {
            return quantityOfDessert * Discount.WEEKDAY_PRICE.getPrice();
        }
        return 0;
    }

    @Override
    public int weekend(Date date, Order order) {
        LocalDate specificDate = LocalDate.of(Calendar.getThisYear(), date.getCalendar().getMonth(), date.getInputDay());
        DayOfWeek dayOfWeek = specificDate.getDayOfWeek();
        Map<Menu, Integer> menus = new HashMap<>();
        boolean isWeekend = dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY;
        int quantityOfMain = counter.countMain(menus);

        if (isWeekend) {
            return quantityOfMain * Discount.WEEKEND_PRICE.getPrice();
        }
        return 0;
    }

    @Override
    public int special(Date date) {
        LocalDate specificDate = LocalDate.of(Calendar.getThisYear(), date.getCalendar().getMonth(), date.getInputDay());
        DayOfWeek dayOfWeek = specificDate.getDayOfWeek();
        boolean isSpecialDay = dayOfWeek == SPECIAL_DAY;

        if (isSpecialDay || date.getInputDay() == CHRISTMAS_DAY) {
            return Discount.SPECIAL_PRICE.getPrice();
        }
        return 0;
    }
}