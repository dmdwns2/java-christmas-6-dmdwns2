package christmas.domain;

import christmas.Date;
import christmas.enums.Calendar;

public class DateManager {
    public Date create(int date) {
        return new Date(Calendar.getThisMonth(), date);
    }
}
