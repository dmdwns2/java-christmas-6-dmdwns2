package christmas.utils;

import christmas.enums.Calendar;
import christmas.enums.Menu;
import christmas.view.OutputView;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    private final OutputView output;

    public Validator(OutputView output) {
        this.output = output;
    }

    public void empty(String input) {
        if (input.isBlank()) {
            output.emptyInput();
            throw new IllegalArgumentException();
        }
    }

    public void convertDate(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            output.invalidDate();
            throw new IllegalArgumentException();
        }
    }

    public void sizeDate(String input, Calendar month) {
        int date = Integer.parseInt(input);
        if (date < month.getStartDay() || date > month.getDays()) {
            output.invalidDate();
            throw new IllegalArgumentException();
        }
    }

    public void invalidMenu(String input) {
        try {
            Menu.valueOf(input);
        } catch (IllegalArgumentException e) {
            output.invalidOrder();
            throw new IllegalArgumentException();
        }
    }

    public void sizeMenuQuantity(String input) {
        int size = Integer.parseInt(input);
        if (size > Menu.getMaxQuantity() || size < Menu.getMinQuantity()) {
            output.invalidOrder();
            throw new IllegalArgumentException();
        }
    }

    public void convertMenuQuantity(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            output.invalidOrder();
            throw new IllegalArgumentException();
        }
    }

    public void parseOrderMatcher(Matcher matcher) {
        if (matcher.matches()) {
            return;
        }
        output.invalidOrder();
        throw new IllegalArgumentException();
    }

    public void duplicateMenu(Map<Menu, Integer> menus, Menu menu) {
        if (menus.containsKey(menu)) {
            output.invalidOrder();
            throw new IllegalArgumentException();
        }
    }

    public void match(String input) {
        try {
            Pattern pattern = Pattern.compile("([^,]+)-(\\d+)");
            pattern.matcher(input);
        } catch (IllegalArgumentException e) {
            output.invalidOrder();
            throw new IllegalArgumentException();
        }
    }
}