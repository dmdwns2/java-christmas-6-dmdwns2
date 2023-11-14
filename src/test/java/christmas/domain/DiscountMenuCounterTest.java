package christmas.domain;

import christmas.enums.Menu;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class DiscountMenuCounterTest {
    @DisplayName("디저트 수를 세는 테스트")
    @Test
    void countDessert() {
        Map<Menu, Integer> menus = new HashMap<>();
        DiscountMenuCounter counter = new DiscountMenuCounter();
        menus.put(Menu.초코케이크, 2);
        menus.put(Menu.아이스크림, 3);
        int dessertCount = counter.countDessert(menus);

        assertThat(dessertCount).isEqualTo(5);
    }

    @DisplayName("메인 메뉴 수를 세는 테스트")
    @Test
    void countMainMenu() {
        Map<Menu, Integer> menus = new HashMap<>();
        DiscountMenuCounter counter = new DiscountMenuCounter();
        menus.put(Menu.티본스테이크, 4);
        menus.put(Menu.바비큐립, 7);
        int mainMenuCount = counter.countMain(menus);

        assertThat(mainMenuCount).isEqualTo(11);
    }
}