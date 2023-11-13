package christmas.domain;

import christmas.enums.Menu;

import java.util.Map;

public interface OrderService {
    Map<Menu, Integer> parse(String input);
}