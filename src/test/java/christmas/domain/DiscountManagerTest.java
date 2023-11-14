package christmas.domain;

import christmas.Date;
import christmas.Order;
import christmas.enums.Calendar;
import christmas.enums.Discount;
import christmas.enums.Menu;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class DiscountManagerTest {
    private final Counter counter = new DiscountMenuCounter();
    private final DiscountManager discountManager = new DiscountManager(counter);

    @DisplayName("메뉴를 증정할지에 대한 확인")
    @Test
    void isGift() {
        int priceBelowGift = Discount.GIFT_PRICE.getPrice() - 1;
        int priceEqualGift = Discount.GIFT_PRICE.getPrice();
        int priceAboveGift = Discount.GIFT_PRICE.getPrice() + 1;
        boolean belowGift = discountManager.isGift(priceBelowGift);
        boolean equalGift = discountManager.isGift(priceEqualGift);
        boolean aboveGift = discountManager.isGift(priceAboveGift);

        assertThat(belowGift).isFalse();
        assertThat(equalGift).isTrue();
        assertThat(aboveGift).isTrue();
    }

    @DisplayName("크리스마스 D-Day 할인 가격 계산 테스트")
    @Test
    void christmasDDay() {
        Date christmasDDay = new Date(Calendar.DECEMBER, 25);
        int christmasDDayDiscount = discountManager.christmasDDay(christmasDDay);

        assertThat(christmasDDayDiscount).isEqualTo(3400);
    }

    @DisplayName("26일에 크리스마스 D-Day 할인 가격 계산 테스트")
    @Test
    void christmasDDay26() {
        Date christmasDDay = new Date(Calendar.DECEMBER, 26);
        int christmasDDayDiscount = discountManager.christmasDDay(christmasDDay);

        assertThat(christmasDDayDiscount).isEqualTo(0);
    }

    @DisplayName("디저트가 포함된 주문의 평일 할인 가격 계산 테스트")
    @Test
    void weekdayWithDessert() {
        Date date = new Date(Calendar.DECEMBER, 5);
        Map<Menu, Integer> menus = new HashMap<>();
        menus.put(Menu.아이스크림, 4);
        menus.put(Menu.티본스테이크, 1);
        Order order = new Order(menus);
        int weekdayDiscountWithDessert = discountManager.weekday(date, order);

        assertThat(weekdayDiscountWithDessert).isEqualTo(4 * Discount.WEEKDAY_PRICE.getPrice());
    }

    @DisplayName("디저트가 없는 주문의 평일 할인 가격 계산 테스트")
    @Test
    void weekdayWithNonDessert() {
        Date date = new Date(Calendar.DECEMBER, 5);
        Map<Menu, Integer> menus = new HashMap<>();
        menus.put(Menu.레드와인, 4);
        menus.put(Menu.티본스테이크, 1);
        Order order = new Order(menus);
        int weekdayDiscountWithDessert = discountManager.weekday(date, order);

        assertThat(weekdayDiscountWithDessert).isEqualTo(0);
    }

    @DisplayName("메인 메뉴가 포함된 주문의 주말 할인 가격 계산 테스트")
    @Test
    void weekendWithMainMenu() {
        Date date = new Date(Calendar.DECEMBER, 10);
        Map<Menu, Integer> menus = new HashMap<>();
        menus.put(Menu.아이스크림, 4);
        menus.put(Menu.티본스테이크, 1);
        Order order = new Order(menus);
        int weekendDiscountWithMainMenu = discountManager.weekend(date, order);

        assertThat(weekendDiscountWithMainMenu).isEqualTo(Discount.WEEKDAY_PRICE.getPrice());
    }

    @DisplayName("메인 메뉴가 없는 주문의 주말 할인 가격 계산 테스트")
    @Test
    void weekendWithNonMainMenu() {
        Date date = new Date(Calendar.DECEMBER, 10);
        Map<Menu, Integer> menus = new HashMap<>();
        menus.put(Menu.레드와인, 4);
        menus.put(Menu.초코케이크, 1);
        Order order = new Order(menus);
        int weekendDiscountWithMainMenu = discountManager.weekend(date, order);

        assertThat(weekendDiscountWithMainMenu).isEqualTo(0);
    }

    @DisplayName("일요일에 스페셜 할인이 제대로 적용 되는지 확인")
    @Test
    void specialWhenSunday() {
        Date date = new Date(Calendar.DECEMBER, 10);
        int specialDiscount = discountManager.special(date);

        assertThat(specialDiscount).isEqualTo(Discount.SPECIAL_PRICE.getPrice());
    }

    @DisplayName("25일에 스페셜 할인이 제대로 적용 되는지 확인")
    @Test
    void specialWhenChristmas() {
        Date date = new Date(Calendar.DECEMBER, 25);
        int specialDiscount = discountManager.special(date);

        assertThat(specialDiscount).isEqualTo(Discount.SPECIAL_PRICE.getPrice());
    }

    @DisplayName("스페셜데이가 아닌 날 스페셜 할인이 적용 되는지 확인")
    @Test
    void specialWhenNotSpecialDay() {
        Date date = new Date(Calendar.DECEMBER, 22);
        int specialDiscount = discountManager.special(date);

        assertThat(specialDiscount).isEqualTo(0);
    }
}