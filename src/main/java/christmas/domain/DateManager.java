package christmas.domain;

import christmas.Date;
import christmas.enums.Calendar;

public class DateManager implements DateService {
    @Override
    public Date create(int date) {
        return new Date(Calendar.getThisMonth(), date);
    }
}