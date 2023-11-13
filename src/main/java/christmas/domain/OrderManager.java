package christmas.domain;

import christmas.Order;

public class OrderManager {
    private final OrderParser orderParser;

    public OrderManager(OrderParser orderParser) {
        this.orderParser = orderParser;
    }

    public Order create(String input) {
        return new Order(orderParser.parse(input));
    }
}
