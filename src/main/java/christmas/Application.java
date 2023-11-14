package christmas;

import christmas.controller.EventPlanner;
import christmas.domain.*;
import christmas.utils.Validator;
import christmas.view.Input;
import christmas.view.InputView;
import christmas.view.Output;
import christmas.view.OutputView;

public class Application {
    public static void main(String[] args) {
        Output output = new OutputView();
        Validator validator = new Validator();
        Input input = new InputView(output, validator);
        DateService dateService = new DateManager();
        Parser parser = new OrderParser(validator);
        OrderService orderService = new OrderManager(parser);
        Counter counter = new DiscountMenuCounter();
        DiscountService discountService = new DiscountManager(counter);
        Calculator calculator = new CalculateManager();
        EventPlanner eventPlanner = new EventPlanner(input, output, dateService, orderService, discountService, calculator);

        eventPlanner.run();
    }
}