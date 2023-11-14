package christmas.domain;

import christmas.enums.Menu;
import christmas.enums.MenuType;

import java.util.Map;

public class DiscountMenuCounter implements Counter {
    @Override
    public int countDessert(Map<Menu, Integer> menus) {
        int total = 0;
        for (Menu key : menus.keySet()) {
            MenuType menuType = key.getType();
            if (menuType == MenuType.디저트) {
                total += menus.get(key);
            }
        }
        return total;
    }

    @Override
    public int countMain(Map<Menu, Integer> menus) {
        int total = 0;
        for (Menu key : menus.keySet()) {
            MenuType menuType = key.getType();
            if (menuType == MenuType.메인) {
                total += menus.get(key);
            }
        }
        return total;
    }
}