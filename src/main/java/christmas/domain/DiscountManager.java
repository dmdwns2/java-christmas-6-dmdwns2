package christmas.domain;

import christmas.Date;
import christmas.Order;
import christmas.enums.Calendar;
import christmas.enums.Menu;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class DiscountManager implements DiscountService {
    private Counter counter;
    private static final int GIFT_PRICE = 120_000;
    private static final int CHRISTMAS_D_DAY_START_PRICE = 1_000;
    private static final int CHRISTMAS_D_DAY_INCREASE_PRICE = 100;
    private static final int WEEKDAY_PRICE = 2_023;
    private static final int WEEKEND_PRICE = 2_023;

    public DiscountManager(Counter counter) {
        this.counter = counter;
    }

    @Override
    public boolean isGift(int price) {
        if (price >= GIFT_PRICE) {
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
        return CHRISTMAS_D_DAY_START_PRICE + CHRISTMAS_D_DAY_INCREASE_PRICE * (date.getInputDay() - 1);
    }

    @Override
    public int weekday(Date date, Order order) {
        LocalDate specificDate = LocalDate.of(Calendar.getThisYear(), date.getCalendar().getMonth(), date.getInputDay());
        DayOfWeek dayOfWeek = specificDate.getDayOfWeek();
        Map<Menu, Integer> menus = new HashMap<>();
        boolean isWeekday = dayOfWeek != DayOfWeek.SATURDAY && dayOfWeek != DayOfWeek.SUNDAY;
        int quantityOfDessert = counter.countDessert(menus);

        if (isWeekday) {
            return quantityOfDessert * WEEKDAY_PRICE;
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
            return quantityOfMain * WEEKEND_PRICE;
        }
        return 0;
    }
}