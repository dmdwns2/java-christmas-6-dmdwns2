package christmas.domain;

import christmas.Date;
import christmas.Order;

public interface DiscountService {
    boolean isGift(int price);

    int christmasDDay(Date date);

    int weekday(Date date, Order order);

    int weekend(Date date, Order order);
}