package christmas.domain;

import christmas.Date;
import christmas.enums.Calendar;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateManagerTest {
    @Test
    void create_shouldReturnValidDate() {
        DateManager dateManager = new DateManager();
        Date date = dateManager.create(15);

        assertEquals(Calendar.getThisMonth(), date.getCalendar());
        assertEquals(15, date.getInputDay());
    }
}