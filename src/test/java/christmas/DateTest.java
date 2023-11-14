package christmas;

import christmas.enums.Calendar;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class DateTest {
    @DisplayName("유효한 날짜로 Date 객체 생성")
    @Test
    void validDateCreation() {
        Date validDate = new Date(Calendar.DECEMBER, 15);

        assertThat(Calendar.DECEMBER).isEqualTo(validDate.getCalendar());
        assertThat(15).isEqualTo(validDate.getInputDay());
    }

    @DisplayName("이벤트가 끝나는 날이 해당 월의 마지막 일보다 큰 경우에 대한 예외 처리")
    @Test
    void invalidDateCreation01() {
        assertThatThrownBy(() ->
                new Date(Calendar.DECEMBER, 32)).isInstanceOf(IllegalArgumentException.class);
    }
}