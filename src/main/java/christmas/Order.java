package christmas;

import christmas.enums.ErrMsg;
import christmas.enums.Menu;
import christmas.enums.MenuType;

import java.util.Map;

public class Order {
    private final Map<Menu, Integer> menus;

    public Order(Map<Menu, Integer> menus) {
        validateEmpty(menus);
        validateSize(menus);
        validateType(menus);
        this.menus = menus;
    }

    private void validateEmpty(Map<Menu, Integer> menus) {
        if (menus.isEmpty()) {
            throw new IllegalArgumentException(ErrMsg.EMPTY_INPUT.getMessage());
        }
    }

    private void validateSize(Map<Menu, Integer> menus) {
        int total = 0;
        for (int value : menus.values()) {
            total += value;
            if (total > Menu.getMaxQuantity()) {
                throw new IllegalArgumentException(ErrMsg.INVALID_ORDER.getMessage());
            }
        }
    }

    private void validateType(Map<Menu, Integer> menus) {
        for (Menu key : menus.keySet()) {
            MenuType menuType = key.getType();
            if (menuType == MenuType.에피타이저 || menuType == MenuType.메인 || menuType == MenuType.디저트) {
                return;
            }
        }
        throw new IllegalArgumentException(ErrMsg.INVALID_ORDER.getMessage());
    }
}