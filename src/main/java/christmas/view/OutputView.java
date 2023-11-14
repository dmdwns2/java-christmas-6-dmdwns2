package christmas.view;

import christmas.Order;
import christmas.enums.Calendar;
import christmas.enums.Menu;
import christmas.enums.OutputMsg;

import java.util.Map;

public class OutputView implements Output {
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
        System.out.println(OutputMsg.ORDER_MENUS);
        for (Menu key : menus.keySet()) {
            System.out.println(key.getName() + " " + menus.get(key) + OutputMsg.QUANTITY_UNIT.getMessage());
        }
        System.out.println();
    }
}