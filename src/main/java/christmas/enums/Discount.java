package christmas.enums;

public enum Discount {
    MIN_PRICE(10_000),
    GIFT_PRICE(120_000),
    CHRISTMAS_D_DAY_START_PRICE(1_000),
    CHRISTMAS_D_DAY_INCREASE_PRICE(100),
    WEEKDAY_PRICE(2_023),
    WEEKEND_PRICE(2_023),
    SPECIAL_PRICE(1_000);

    private final int price;

    Discount(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}