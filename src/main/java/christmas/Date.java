package christmas;

import christmas.enums.Calendar;
import christmas.enums.ErrMsg;

public class Date {
    private final Calendar calendar;
    private final int inputDay;

    public Date(Calendar calendar, int inputDay) {
        validate(calendar, inputDay);
        this.calendar = calendar;
        this.inputDay = inputDay;
    }

    public void validate(Calendar calendar, int inputDay) {
        if (Calendar.getEventEndDay() > calendar.getDays()) {
            throw new IllegalArgumentException(ErrMsg.INVALID_DATE.getMessage());
        }
        if (inputDay < Calendar.getEventStartDay() || inputDay > Calendar.getEventEndDay()) {
            throw new IllegalArgumentException(ErrMsg.INVALID_DATE.getMessage());
        }
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public int getInputDay() {
        return inputDay;
    }
}