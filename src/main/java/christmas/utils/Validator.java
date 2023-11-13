package christmas.utils;

import christmas.enums.Calendar;
import christmas.enums.ErrMsg;
import christmas.enums.Menu;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    public void empty(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ErrMsg.EMPTY_INPUT.getMessage());
        }
    }

    public void convertDate(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrMsg.INVALID_DATE.getMessage());
        }
    }

    public void sizeDate(String input, Calendar calendar) {
        int date = Integer.parseInt(input);
        if (date < calendar.getStartDay() || date > calendar.getDays()) {
            throw new IllegalArgumentException(ErrMsg.INVALID_DATE.getMessage());
        }
    }

    public void invalidOrder(String input) {
        try {
            Menu.valueOf(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ErrMsg.INVALID_ORDER.getMessage());
        }
    }

    public void convertMenuQuantity(String input) {
        try {
            String[] quantity = input.split("-");
            for (int i = 1; i < quantity.length; i++) {
                Integer.parseInt(quantity[i]);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrMsg.INVALID_ORDER.getMessage());
        }
    }

    public void duplicateMenu(Map<Menu, Integer> menus, Menu menu) {
        if (menus.containsKey(menu)) {
            throw new IllegalArgumentException(ErrMsg.INVALID_ORDER.getMessage());
        }
    }

    public void match(String input) {
        try {
            Pattern pattern = Pattern.compile("([^,]+)-(\\d+)");
            Matcher matcher = pattern.matcher(input);
            invalidOrder(matcher);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ErrMsg.INVALID_ORDER.getMessage());
        }
    }

    private void invalidOrder(Matcher matcher) {
        Map<Menu, Integer> menus = new HashMap<>();
        int sum = 0;
        while (matcher.find()) {
            String menuName = matcher.group(1);
            String quantity = matcher.group(2);
            invalidOrder(menuName);
            duplicateMenu(menus, Menu.valueOf(menuName));
            sum += Integer.parseInt(quantity);
            sizeMenuQuantity(sum);
            menus.put(Menu.valueOf(menuName), Integer.parseInt(quantity));
        }
    }

    private void sizeMenuQuantity(int sumOfQuantity) {
        if (sumOfQuantity > Menu.getMaxQuantity() || sumOfQuantity < Menu.getMinQuantity()) {
            throw new IllegalArgumentException(ErrMsg.INVALID_ORDER.getMessage());
        }
    }
}