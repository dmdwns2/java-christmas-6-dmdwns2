package christmas.domain;

import christmas.Order;

public class OrderManager {
    private final OrderService orderService;

    public OrderManager(OrderService orderService) {
        this.orderService = orderService;
    }

    public Order create(String input) {
        return new Order(orderService.parse(input));
    }
}