package christmas.domain;

import christmas.Order;
import christmas.view.OutputView;

public class OrderManager {
    private final OrderParser orderParser;

    public OrderManager(OutputView output, OrderParser orderParser) {
        this.orderParser = orderParser;
    }

    public Order create(String input) {
        return new Order(orderParser.parse(input));
    }
}
