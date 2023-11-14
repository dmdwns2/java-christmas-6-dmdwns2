package christmas.view;

import christmas.Order;
import christmas.enums.Calendar;

public interface Output {
    void printIntro();

    void printReadDate();

    void printReadOrder();

    void printPreview(Calendar calendar, int data);

    void printMenus(Order order);

    void printTotalPriceBeforDiscount(int price);

    void printGiftMenu(boolean isGift);

    void printBenefitsDetails(boolean isGift, int priceAfterChristmasDDayDiscount,
                              int priceAfterWeekdayDiscount, int priceAfterWeekendDiscount,
                              int priceAfterSpecialDayDiscount);

    void printNonBenefitsDetails();

    void printTotalBenefitsPrice(int totalBenefitsPrice);

    void printPriceAfterDiscount(int priceAfterDiscount);
}