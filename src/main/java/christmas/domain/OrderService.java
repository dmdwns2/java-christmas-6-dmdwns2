package christmas.domain;

import christmas.Order;

public interface OrderService {
    Order create(String input);

    int calculateTotalPriceBeforeDiscount(Order order);
}