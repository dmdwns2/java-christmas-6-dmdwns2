package christmas.domain;

import christmas.Order;

public class OrderManager implements OrderService {
    private final Parser parser;

    public OrderManager(Parser parser) {
        this.parser = parser;
    }

    public Order create(String input) {
        return new Order(parser.parse(input));
    }
}