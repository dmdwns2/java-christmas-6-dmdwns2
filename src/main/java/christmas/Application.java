package christmas;

import christmas.controller.EventPlanner;
import christmas.domain.DateManager;
import christmas.domain.DateService;
import christmas.domain.OrderParser;
import christmas.domain.OrderService;
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
        OrderService orderService = new OrderParser(validator);
        EventPlanner eventPlanner = new EventPlanner(input, output, dateService, orderService);

        eventPlanner.run();
    }
}