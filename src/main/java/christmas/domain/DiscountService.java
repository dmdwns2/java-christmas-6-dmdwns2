package christmas.domain;

import christmas.Date;
import christmas.Order;

public interface DiscountService {
    boolean isGift(int price);

    int christmasDDay(Date date);

    int weekday(Date date, Order order);

    int weekend(Date date, Order order);

    int special(Date date);

    int calculateTotalBenefitsPrice(boolean isGift, int priceAfterChristmasDDayDiscount,
                                    int priceAfterWeekdayDiscount, int priceAfterWeekendDiscount,
                                    int priceAfterSpecialDayDiscount);

    int calculatePriceAfterDiscount(boolean isGift, int totalPriceBeforeDiscount, int totalBenefitsPrice);
}