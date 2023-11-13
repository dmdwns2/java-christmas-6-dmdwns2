package christmas;

import christmas.enums.Menu;
import christmas.view.OutputView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class OrderTest {
    private Map<Menu, Integer> menus;
    private OutputView output;

    @BeforeEach
    void setUp() {
        menus = new HashMap<>();
        output = new OutputView();
    }

    @Test
    void 주문생성시_빈메뉴일때_예외발생() {
        assertThrows(IllegalArgumentException.class, () -> new Order(output, menus));
    }

    @Test
    void 주문생성시_총합이_최대치를_초과할때_예외발생() {
        menus.put(Menu.레드와인, 15);
        menus.put(Menu.바비큐립, 10);
        assertThrows(IllegalArgumentException.class, () -> new Order(output, menus));
    }

    @Test
    void 주문생성시_필수메뉴타입이_포함되지_않을때_예외발생() {
        menus.put(Menu.샴페인, 5);
        menus.put(Menu.레드와인, 3);
        menus.put(Menu.제로콜라, 2);
        assertThrows(IllegalArgumentException.class, () -> new Order(output, menus));
    }

    @Test
    void 주문생성시_유효한메뉴일때_주문생성() {
        menus.put(Menu.레드와인, 3);
        menus.put(Menu.바비큐립, 5);
        menus.put(Menu.샴페인, 2);

        Order order = new Order(output, menus);

        assertThat(order).isNotNull();
    }
}