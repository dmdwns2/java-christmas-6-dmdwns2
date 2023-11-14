package christmas.enums;

public enum EventBadge {
    NONE("없음", 0),
    STAR("별", 5_000),
    TREE("트리", 10_000),
    SANTA("산타", 20_000);

    private final String name;
    private final int discountPrice;

    EventBadge(String name, int discountPrice) {
        this.name = name;
        this.discountPrice = discountPrice;
    }

    public String getName() {
        return name;
    }

    public static EventBadge getEventBadge(int price) {
        if (price >= SANTA.discountPrice) {
            return SANTA;
        }
        if (price >= TREE.discountPrice) {
            return TREE;
        }
        if (price >= STAR.discountPrice) {
            return STAR;
        }
        return NONE;
    }
}
