package christmas.view;

import christmas.Order;
import christmas.enums.Calendar;
import christmas.enums.Menu;

import java.text.DecimalFormat;
import java.util.Map;

import static christmas.enums.OutputMsg.*;

public class OutputView implements Output {
    private static final DecimalFormat decimalFormat = new DecimalFormat("###,###");

    @Override
    public void printIntro() {
        System.out.println(INTRO.getMessage());
    }

    @Override
    public void printReadDate() {
        System.out.println(READ_DATE.getMessage());
    }

    @Override
    public void printReadOrder() {
        System.out.println(READ_ORDER.getMessage());
    }

    @Override
    public void printPreview(Calendar month, int date) {
        System.out.println(month.getMonth() + MONTH_UNIT.getMessage() +
                date + DAY_UNIT.getMessage() + PREVIEW.getMessage());
        System.out.println();
    }

    @Override
    public void printMenus(Order order) {
        Map<Menu, Integer> menus = order.getMenus();
        System.out.println(TITLE_ORDER_MENUS.getMessage());
        for (Menu key : menus.keySet()) {
            System.out.println(key.getName() + " " + menus.get(key) + QUANTITY_UNIT.getMessage());
        }
        System.out.println();
    }

    @Override
    public void printTotalPriceBeforDiscount(int price) {
        System.out.println(TITLE_TOTAL_PRICE_BEFOR_DISCOUNT.getMessage());
        System.out.println(decimalFormat.format(price) + MONETARY_UNIT.getMessage());
        System.out.println();
    }

    @Override
    public void printGiftMenu(boolean isGift) {
        System.out.println(TITLE_GIFT_MENU.getMessage());
        if (isGift) {
            System.out.println(Menu.getGiftMenu().getName() + " " + Menu.getGiftMenuQuantity() + QUANTITY_UNIT.getMessage());
            return;
        }
        System.out.println(NONE.getMessage());
        System.out.println();
    }

    @Override
    public void printBenefitsDetails(boolean isGift, int priceAfterChristmasDDayDiscount,
                                     int priceAfterWeekdayDiscount, int priceAfterWeekendDiscount,
                                     int priceAfterSpecialDayDiscount) {
        System.out.println(TITLE_BENEFITS_DETAILS.getMessage());
        printGiftDetails(isGift);
        printDiscountDetails(DETAILS_CHRISTMAS_D_DAY.getMessage(), priceAfterChristmasDDayDiscount);
        printDiscountDetails(DETAILS_WEEKDAY.getMessage(), priceAfterWeekdayDiscount);
        printDiscountDetails(DETAILS_WEEKEND.getMessage(), priceAfterWeekendDiscount);
        printDiscountDetails(DETAILS_SPECIAL.getMessage(), priceAfterSpecialDayDiscount);
        System.out.println();
    }

    @Override
    public void printNonBenefitsDetails() {
        System.out.println(TITLE_BENEFITS_DETAILS.getMessage());
        System.out.println(NONE.getMessage());
        System.out.println();
    }

    private void printGiftDetails(boolean isGift) {
        if (isGift) {
            System.out.println(DETAILS_GIFT.getMessage() + decimalFormat.format(Menu.getGiftMenu().getPrice()) + MONETARY_UNIT.getMessage());
        }
    }

    private void printDiscountDetails(String message, int priceAfterDiscount) {
        if (priceAfterDiscount != 0) {
            System.out.println(message + decimalFormat.format(priceAfterDiscount) + MONETARY_UNIT.getMessage());
        }
    }
}