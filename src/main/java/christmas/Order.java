package christmas;

import christmas.enums.Menu;
import christmas.enums.MenuType;
import christmas.view.OutputView;

import java.util.Map;

public class Order {
    private final Map<Menu, Integer> menus;
    private final OutputView output;

    public Order(OutputView output, Map<Menu, Integer> menus) {
        this.output = output;
        validateEmpty(menus);
        validateSize(menus);
        validateType(menus);
        this.menus = menus;
    }

    private void validateEmpty(Map<Menu, Integer> menus) {
        if (menus.isEmpty()) {
            output.invalidOrder();
            throw new IllegalArgumentException();
        }
    }

    private void validateSize(Map<Menu, Integer> menus) {
        int total = 0;
        for (int value : menus.values()) {
            total += value;
            if (total > Menu.getMaxQuantity()) {
                output.invalidOrder();
                throw new IllegalArgumentException();
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
        output.invalidOrder();
        throw new IllegalArgumentException();
    }
}