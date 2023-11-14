package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.utils.Validator;

public class InputView implements Input {
    private final Output output;
    private final Validator validator;

    public InputView(Output output, Validator validator) {
        this.output = output;
        this.validator = validator;
    }

    @Override
    public int readDate() {
        try {
            output.printReadDate();
            String input = Console.readLine();
            validator.empty(input);
            validator.convertDate(input);
            validator.sizeDate(input);
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readDate();
        }
    }

    @Override
    public String readOrder() {
        try {
            output.printReadOrder();
            String input = Console.readLine();
            validator.empty(input);
            validator.invalidOrderInput(input);
            validator.convertMenuQuantity(input);
            validator.match(input);
            return input;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readOrder();
        }
    }
}