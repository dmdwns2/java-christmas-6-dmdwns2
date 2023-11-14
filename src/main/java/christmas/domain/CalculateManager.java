package christmas.domain;

import christmas.enums.EventBadge;
import christmas.enums.Menu;

public class CalculateManager implements Calculator {
    @Override
    public int totalBenefitsPrice(boolean isGift, int priceAfterChristmasDDayDiscount,
                                  int priceAfterWeekdayDiscount, int priceAfterWeekendDiscount,
                                  int priceAfterSpecialDayDiscount) {
        int total = 0;
        if (isGift) {
            total += Menu.getGiftMenu().getPrice();
        }
        total += priceAfterChristmasDDayDiscount + priceAfterWeekdayDiscount + priceAfterWeekendDiscount + priceAfterSpecialDayDiscount;
        return total;
    }

    @Override
    public int priceAfterDiscount(boolean isGift, int totalPriceBeforeDiscount, int totalBenefitsPrice) {
        if (isGift) {
            totalBenefitsPrice -= Menu.getGiftMenu().getPrice();
        }
        return totalPriceBeforeDiscount - totalBenefitsPrice;
    }

    @Override
    public EventBadge eventBadge(int printTotalBenefitsPrice) {
        return EventBadge.getEventBadge(printTotalBenefitsPrice);
    }
}