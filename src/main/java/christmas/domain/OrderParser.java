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
        validator.parseOrderMatcher(matcher);
        while (matcher.find()) {
            validator.invalidMenu(matcher.group(1));
            validator.duplicateMenu(menus, Menu.valueOf(matcher.group(1)));
            validator.convertMenuQuantity(matcher.group(2));
            validator.sizeMenuQuantity(matcher.group(2));
            menus.put(Menu.valueOf(matcher.group(1)), Integer.parseInt(matcher.group(2)));
        }
        return menus;
    }
}
