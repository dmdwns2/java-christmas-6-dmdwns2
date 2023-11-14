package christmas.domain;

import christmas.enums.EventBadge;

public interface Calculator {
    int totalBenefitsPrice(boolean isGift, int priceAfterChristmasDDayDiscount,
                           int priceAfterWeekdayDiscount, int priceAfterWeekendDiscount,
                           int priceAfterSpecialDayDiscount);

    int priceAfterDiscount(boolean isGift, int totalPriceBeforeDiscount, int totalBenefitsPrice);

    EventBadge eventBadge(int printTotalBenefitsPrice);
}