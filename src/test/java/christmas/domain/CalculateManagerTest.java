package christmas.domain;

import christmas.enums.EventBadge;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculateManagerTest {
    @DisplayName("총 혜택 금액 계산에 대한 확인, 증정 선물이 있을 때")
    @Test
    void totalBenefitsPriceWithGift() {
        Calculator calculator = new CalculateManager();
        boolean isGift = true;
        int priceAfterChristmasDDayDiscount = 5000;
        int priceAfterWeekdayDiscount = 3000;
        int priceAfterWeekendDiscount = 2000;
        int priceAfterSpecialDayDiscount = 1000;

        int totalBenefitsPrice = calculator.totalBenefitsPrice(isGift, priceAfterChristmasDDayDiscount,
                priceAfterWeekdayDiscount, priceAfterWeekendDiscount, priceAfterSpecialDayDiscount);

        assertThat(36000).isEqualTo(totalBenefitsPrice);
    }

    @DisplayName("총 혜택 금액 계산에 대한 확인, 증정 선물이 없을 때")
    @Test
    void totalBenefitsPriceWithoutGift() {
        Calculator calculator = new CalculateManager();
        boolean isGift = false;
        int priceAfterChristmasDDayDiscount = 5000;
        int priceAfterWeekdayDiscount = 3000;
        int priceAfterWeekendDiscount = 2000;
        int priceAfterSpecialDayDiscount = 1000;

        int totalBenefitsPrice = calculator.totalBenefitsPrice(isGift, priceAfterChristmasDDayDiscount,
                priceAfterWeekdayDiscount, priceAfterWeekendDiscount, priceAfterSpecialDayDiscount);

        assertThat(11000).isEqualTo(totalBenefitsPrice);
    }

    @DisplayName("할인 후 결제 해야할 금액에 대한 확인, 증정 메뉴가 있을 때")
    @Test
    void priceAfterDiscountWithGift() {
        Calculator calculator = new CalculateManager();
        boolean isGift = true;
        int totalPriceBeforeDiscount = 20000;
        int totalBenefitsPrice = 36000;
        int priceAfterDiscount = calculator.priceAfterDiscount(isGift, totalPriceBeforeDiscount, totalBenefitsPrice);

        assertThat(9000).isEqualTo(priceAfterDiscount);
    }

    @DisplayName("할인 후 결제 해야할 금액에 대한 확인, 증정 메뉴가 없을 때")
    @Test
    void priceAfterDiscountWithOutGift() {
        Calculator calculator = new CalculateManager();
        boolean isGift = false;
        int totalPriceBeforeDiscount = 20000;
        int totalBenefitsPrice = 11000;
        int priceAfterDiscount = calculator.priceAfterDiscount(isGift, totalPriceBeforeDiscount, totalBenefitsPrice);

        assertThat(9000).isEqualTo(priceAfterDiscount);
    }

    @DisplayName("5천원 결제에 대한 이벤트 뱃지가 스타인지 확인")
    @Test
    void eventBadge() {
        Calculator calculator = new CalculateManager();
        int printTotalBenefitsPrice = 5000;
        EventBadge badge = calculator.eventBadge(printTotalBenefitsPrice);

        assertThat(EventBadge.STAR).isEqualTo(badge);
    }

    @DisplayName("4999원 결제에 대한 이벤트 뱃지가 없는지 확인")
    @Test
    void nonEventBadge() {
        Calculator calculator = new CalculateManager();
        int printTotalBenefitsPrice = 4999;
        EventBadge badge = calculator.eventBadge(printTotalBenefitsPrice);

        assertThat(EventBadge.NONE).isEqualTo(badge);
    }
}