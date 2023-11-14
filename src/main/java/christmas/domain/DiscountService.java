package christmas.domain;

import christmas.Date;

public interface DiscountService {
    boolean isGift(int price);

    int christmasDDay(Date date);
}