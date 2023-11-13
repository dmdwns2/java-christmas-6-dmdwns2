package christmas.controller;

import christmas.Date;
import christmas.domain.DateService;
import christmas.domain.OrderService;
import christmas.view.Input;
import christmas.view.Output;

public class EventPlanner {
    private final Input input;
    private final Output output;
    private final DateService dateService;
    private final OrderService orderService;

    public EventPlanner(Input input, Output output, DateService dateService, OrderService orderService) {
        this.input = input;
        this.output = output;
        this.dateService = dateService;
        this.orderService = orderService;
    }

    public void run() {
        output.printIntro();
        Date date = dateService.create(input.readDate());
        String order = input.readOrder();
        output.printPreview(date.getMonth(), date.getInputDay());
    }
}