package christmas.controller;

import christmas.Date;
import christmas.Order;
import christmas.domain.Calculator;
import christmas.domain.DateService;
import christmas.domain.DiscountService;
import christmas.domain.OrderService;
import christmas.enums.Discount;
import christmas.enums.EventBadge;
import christmas.view.Input;
import christmas.view.Output;

public class EventPlanner {
    private final Input input;
    private final Output output;
    private final DateService dateService;
    private final OrderService orderService;
    private final DiscountService discountService;
    private final Calculator calculator;

    public EventPlanner(Input input, Output output, DateService dateService, OrderService orderService, DiscountService discountService, Calculator calculator) {
        this.input = input;
        this.output = output;
        this.dateService = dateService;
        this.orderService = orderService;
        this.discountService = discountService;
        this.calculator = calculator;
    }

    public void run() {
        output.printIntro();
        Date date = dateService.create(input.readDate());
        Order order = orderService.create(input.readOrder());
        int totalPriceBeforeDiscount = calculator.calculateTotalPriceBeforeDiscount(order);
        output.printPreview(date.getCalendar(), date.getInputDay());
        output.printMenus(order);
        output.printTotalPriceBeforDiscount(totalPriceBeforeDiscount);
        discount(date, order, totalPriceBeforeDiscount);
    }

    private void discount(Date date, Order order, int totalPriceBeforeDiscount) {
        if (totalPriceBeforeDiscount < Discount.MIN_PRICE.getPrice()) {
            output.printNonBenefitsDetails();
            return;
        }
        boolean isGift = discountService.isGift(totalPriceBeforeDiscount);
        int priceAfterChristmasDDayDiscount = discountService.christmasDDay(date);
        int priceAfterWeekdayDiscount = discountService.weekday(date, order);
        int priceAfterWeekendDiscount = discountService.weekend(date, order);
        int priceAfterSpecialDayDiscount = discountService.special(date);
        output.printGiftMenu(isGift);
        output.printBenefitsDetails(isGift, priceAfterChristmasDDayDiscount,
                priceAfterWeekdayDiscount, priceAfterWeekendDiscount, priceAfterSpecialDayDiscount);
        calculate(isGift, totalPriceBeforeDiscount, priceAfterChristmasDDayDiscount, priceAfterWeekdayDiscount, priceAfterWeekendDiscount, priceAfterSpecialDayDiscount);
    }

    private void calculate(boolean isGift, int totalPriceBeforeDiscount, int priceAfterChristmasDDayDiscount,
                           int priceAfterWeekdayDiscount, int priceAfterWeekendDiscount,
                           int priceAfterSpecialDayDiscount) {
        int totalBenefitsPrice = calculator.totalBenefitsPrice(isGift, priceAfterChristmasDDayDiscount,
                priceAfterWeekdayDiscount, priceAfterWeekendDiscount, priceAfterSpecialDayDiscount);
        int priceAfterDiscount = calculator.priceAfterDiscount(isGift, totalPriceBeforeDiscount, totalBenefitsPrice);
        EventBadge eventBadge = calculator.eventBadge(totalBenefitsPrice);
        output.printTotalBenefitsPrice(totalBenefitsPrice);
        output.printPriceAfterDiscount(priceAfterDiscount);
        output.printEventBadge(eventBadge);
    }
}