package christmas.enums;

public enum OutputMsg {
    MONTH_UNIT("월"),
    DAY_UNIT("일"),
    QUANTITY_UNIT("개"),
    MONETARY_UNIT("원"),
    NONE("없음"),
    INTRO("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."),
    READ_DATE("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)"),
    READ_ORDER("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)"),
    PREVIEW("에 우테코 식당에서 받을 이벤트 혜택 미리 보기!"),
    TITLE_ORDER_MENUS("<주문 메뉴>"),
    TITLE_TOTAL_PRICE_BEFOR_DISCOUNT("<할인 전 총주문 금액>"),
    TITLE_GIFT_MENU("<증정 메뉴>"),
    TITLE_BENEFITS_DETAILS("<혜택 내역>"),
    TITLE_TOTAL_BENEFIT_PRICE("<총혜택 금액>"),
    TITLE_PRICE_AFTER_DISCOUNT("<할인 후 예상 결제 금액>"),
    TITLE_THIS_MONTH_EVENT_BADGE(Calendar.getThisMonth()+MONTH_UNIT.getMessage()+" 이벤트 배지");

    private final String message;

    OutputMsg(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}