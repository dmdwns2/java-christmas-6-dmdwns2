package christmas.enums;

public enum Menu {
    양송이수프("양송이수프", 6000, MenuType.에피타이저),
    타파스("타파스", 5500, MenuType.에피타이저),
    시저샐러드("시저샐러드", 8000, MenuType.에피타이저),

    티본스테이크("티본스테이크", 55000, MenuType.메인),
    바비큐립("바비큐립", 54000, MenuType.메인),
    해산물파스타("해산물파스타", 35000, MenuType.메인),
    크리스마스파스타("크리스마스파스타", 25000, MenuType.메인),

    초코케이크("초코케이크", 15000, MenuType.디저트),
    아이스크림("아이스크림", 5000, MenuType.디저트),

    제로콜라("제로콜라", 3000, MenuType.음료),
    레드와인("레드와인", 60000, MenuType.음료),
    샴페인("샴페인", 25000, MenuType.음료);

    private final static int MAX_QUANTITY = 20;
    private final static int MIN_QUANTITY = 1;
    private final static Menu GIFT_MENU = 샴페인;
    private final static int GIFT_MENU_QUANTITY = 1;

    private final String name;
    private final int price;
    private final MenuType type;

    Menu(String name, int price, MenuType type) {
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public static MenuType getTypeByName(String name) {
        for (Menu menu : Menu.values()) {
            if (menu.getName().equals(name)) {
                return menu.getType();
            }
        }
        throw new IllegalArgumentException();
    }

    public static int getMaxQuantity() {
        return MAX_QUANTITY;
    }

    public static int getMinQuantity() {
        return MIN_QUANTITY;
    }

    public static Menu getGiftMenu() {
        return GIFT_MENU;
    }

    public static int getGiftMenuQuantity() {
        return GIFT_MENU_QUANTITY;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public MenuType getType() {
        return type;
    }
}