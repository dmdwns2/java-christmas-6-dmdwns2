package christmas.domain;

import christmas.Order;
import christmas.enums.Menu;
import christmas.utils.Validator;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

class OrderManagerTest {
    private final Parser parser = new OrderParser(new Validator());
    private final OrderService orderService = new OrderManager(parser);

    @Test
    void 주문_생성_성공() {
        String input = "초코케이크-1,제로콜라-1";
        Map<Menu,Integer> menus = new HashMap<>();
        menus.put(Menu.초코케이크,1);
        menus.put(Menu.제로콜라,1);
        Order order = new Order(menus);
        assertThat(order).isEqualToComparingFieldByField(orderService.create(input));
        assertThatCode(() -> orderService.create(input)).doesNotThrowAnyException();
    }
}