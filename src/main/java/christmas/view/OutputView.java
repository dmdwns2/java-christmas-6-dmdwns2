package christmas.view;

import christmas.Order;
import christmas.enums.Calendar;
import christmas.enums.Menu;
import christmas.enums.OutputMsg;

import java.text.DecimalFormat;
import java.util.Map;

public class OutputView implements Output {
    private static final DecimalFormat decimalFormat = new DecimalFormat("###,###");

    @Override
    public void printIntro() {
        System.out.println(OutputMsg.INTRO.getMessage());
    }

    @Override
    public void printReadDate() {
        System.out.println(OutputMsg.READ_DATE.getMessage());
    }

    @Override
    public void printReadOrder() {
        System.out.println(OutputMsg.READ_ORDER.getMessage());
    }

    @Override
    public void printPreview(Calendar month, int date) {
        System.out.println(month.getMonth() + OutputMsg.MONTH_UNIT.getMessage() +
                date + OutputMsg.DAY_UNIT.getMessage() + OutputMsg.PREVIEW.getMessage());
        System.out.println();
    }

    @Override
    public void printMenus(Order order) {
        Map<Menu, Integer> menus = order.getMenus();
        System.out.println(OutputMsg.TITLE_ORDER_MENUS.getMessage());
        for (Menu key : menus.keySet()) {
            System.out.println(key.getName() + " " + menus.get(key) + OutputMsg.QUANTITY_UNIT.getMessage());
        }
        System.out.println();
    }

    @Override
    public void printTotalPriceBeforDiscount(int price) {
        System.out.println(OutputMsg.TITLE_TOTAL_PRICE_BEFOR_DISCOUNT.getMessage());
        System.out.println(decimalFormat.format(price) + OutputMsg.MONETARY_UNIT.getMessage());
    }

    @Override
    public void printGiftMenu(boolean isGift) {
        System.out.println(OutputMsg.TITLE_GIFT_MENU.getMessage());
        if (isGift) {
            System.out.println(Menu.getGiftMenu().getName() + " " + Menu.getGiftMenuQuantity() + OutputMsg.QUANTITY_UNIT.getMessage());
            return;
        }
        System.out.println(OutputMsg.NONE.getMessage());
    }
}