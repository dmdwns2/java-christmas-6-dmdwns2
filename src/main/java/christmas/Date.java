package christmas;

import christmas.enums.Calendar;
import christmas.enums.ErrMsg;

public class Date {
    private final Calendar month;
    private final int inputDay;

    public Date(Calendar calendar, int inputDay) {
        validate(calendar, inputDay);
        this.month = calendar;
        this.inputDay = inputDay;
    }

    public void validate(Calendar calendar, int inputDay) {
        if (calendar.getMonth() != Calendar.getThisMonth().getMonth()) {
            throw new IllegalArgumentException(ErrMsg.INVALID_DATE.getMessage());
        }
        if (inputDay < calendar.getStartDay() || inputDay > calendar.getDays()) {
            throw new IllegalArgumentException(ErrMsg.INVALID_DATE.getMessage());
        }
    }
}