package christmas.domain;

import christmas.Order;
import christmas.enums.Menu;

import java.util.Map;

public class OrderManager implements OrderService {
    private final Parser parser;

    public OrderManager(Parser parser) {
        this.parser = parser;
    }

    @Override
    public Order create(String input) {
        return new Order(parser.parse(input));
    }

    @Override
    public int calculateTotalPriceBeforeDiscount(Order order) {
        Map<Menu, Integer> menus = order.getMenus();
        int totalPrice = 0;

        for (Map.Entry<Menu, Integer> entry : menus.entrySet()) {
            Menu menu = entry.getKey();
            int quantity = entry.getValue();
            int menuPrice = menu.getPrice();
            totalPrice += menuPrice * quantity;
        }
        return totalPrice;
    }
}