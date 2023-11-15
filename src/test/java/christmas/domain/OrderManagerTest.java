package christmas.domain;

import christmas.Order;
import christmas.enums.Menu;
import christmas.utils.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

class OrderManagerTest {
    private final Parser parser = new OrderParser(new Validator());
    private final OrderService orderService = new OrderManager(parser);

    @DisplayName("주문 생성 성공")
    @Test
    void createOrder() {
        String input = "초코케이크-1,제로콜라-1";
        Map<Menu, Integer> menus = new HashMap<>();
        menus.put(Menu.초코케이크, 1);
        menus.put(Menu.제로콜라, 1);
        Order order = new Order(menus);
        assertThat(order).isEqualToComparingFieldByField(orderService.create(input));
        assertThatCode(() -> orderService.create(input)).doesNotThrowAnyException();
    }

    @DisplayName("주문을 생성하고 총 가격을 계산하는 테스트")
    @Test
    void createOrderAndCalculateTotalPrice() {
        Map<Menu, Integer> orderItems = new HashMap<>();
        orderItems.put(Menu.아이스크림, 2);
        orderItems.put(Menu.초코케이크, 3);

        Parser parser = new OrderParser(new Validator());
        OrderManager orderManager = new OrderManager(parser);
        Calculator calculator = new CalculateManager();
        String input = "아이스크림-2,초코케이크-3";

        Order order = orderManager.create(input);
        int totalPrice = calculator.calculateTotalPriceBeforeDiscount(order);

        assertThat(order.getMenus()).isEqualTo(orderItems);
        assertThat(totalPrice).isEqualTo(2 * Menu.아이스크림.getPrice() + 3 * Menu.초코케이크.getPrice());
    }
}