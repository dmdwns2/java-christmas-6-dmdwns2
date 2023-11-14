package christmas.domain;

import christmas.enums.Menu;

import java.util.Map;

public interface Counter {
    int countDessert(Map<Menu, Integer> menus);

    int countMain(Map<Menu, Integer> menus);
}