package christmas.domain;

import christmas.utils.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class OrderParserTest {
    private OrderParser orderParser;
    private Validator validator;

    @BeforeEach
    void setUp() {
        validator = new Validator();
        orderParser = new OrderParser(validator);
    }

    @Test
    void 입력이_정상일_때() {
        String input = "아이스크림-3,초코케이크-2";
        assertThatCode(() -> orderParser.parse(input)).doesNotThrowAnyException();
    }

    @Test
    void 입력이_정규표현식과_다를_때() {
        String input = "아이스크림-3,초코케이크맛있다";
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> orderParser.parse(input));
    }

    @Test
    void 메뉴_수량이_최대를_넘을_때() {
        String input = "아이스크림-3,초코케이크-20,제로콜라-16";
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> orderParser.parse(input));
    }

    @Test
    void 메뉴_수량이_숫자가_아닐_때() {
        String input = "아이스크림-3,초코케이크-많이";
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> orderParser.parse(input));
    }

    @Test
    void 메뉴가_중복일_때() {
        String input = "아이스크림-3,아이스크림-6,초코케이크-2";
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> orderParser.parse(input));
    }
}