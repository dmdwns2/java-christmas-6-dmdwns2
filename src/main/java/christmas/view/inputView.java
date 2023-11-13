package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.Order;
import christmas.domain.OrderManager;
import christmas.enums.Calendar;
import christmas.utils.Validator;

public class inputView {
    private final OutputView output;
    private final Validator validator;
    private final OrderManager orderManager;
    private static final Calendar THIS_MONTH = Calendar.DECEMBER;

    public inputView(OutputView output, Validator validator, OrderManager orderManager) {
        this.output = output;
        this.validator = validator;
        this.orderManager = orderManager;
    }

    public int readDate() {
        output.printReadDate();
        String input = Console.readLine();
        validator.empty(input);
        validator.convertDate(input);
        validator.sizeDate(input, THIS_MONTH);
        return Integer.parseInt(input);
    }

    public Order readOrder() {
        output.printReadOrder();
        String input = Console.readLine();
        validator.empty(input);
        return orderManager.create(input);
    }
}