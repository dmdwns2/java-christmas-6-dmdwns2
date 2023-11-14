package christmas.domain;

import christmas.Date;
import christmas.enums.Calendar;

public class DiscountManager implements DiscountService {
    private static final int GIFT_PRICE = 120_000;
    private static final int CHRISTMAS_D_DAY_START_PRICE = 1_000;
    private static final int CHRISTMAS_D_DAY_INCREASE_PRICE = 100;

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
}