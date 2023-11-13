package christmas.domain;

import christmas.enums.Menu;
import christmas.utils.Validator;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OrderParser {
    private final Validator validator;

    public OrderParser(Validator validator) {
        this.validator = validator;
    }

    public Map<Menu, Integer> parse(String input) {
        Map<Menu, Integer> menus = new HashMap<>();
        validator.match(input);
        Pattern pattern = Pattern.compile("([^,]+)-(\\d+)");
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            menus.put(Menu.valueOf(matcher.group(1)), Integer.parseInt(matcher.group(2)));
        }
        return menus;
    }
}
