package christmas.enums;

public enum Calendar {
    JANUARY(31),
    FEBRUARY(28),
    MARCH(31),
    APRIL(30),
    MAY(31),
    JUNE(30),
    JULY(31),
    AUGUST(31),
    SEPTEMBER(30),
    OCTOBER(31),
    NOVEMBER(30),
    DECEMBER(31);

    private static final int EVENT_START_DAY = 1;

    private final int days;

    Calendar(int days) {
        this.days = days;
    }

    public int getDays() {
        return days;
    }

    public int getStartDay() {
        return EVENT_START_DAY;
    }
}
