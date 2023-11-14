package christmas.enums;

public enum OutputMsg {
    MONTH_UNIT("월"),
    DAY_UNIT("일"),
    QUANTITY_UNIT("개"),
    ORDER_MENUS("<주문 메뉴>"),
    INTRO("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."),
    READ_DATE("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)"),
    READ_ORDER("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)"),
    PREVIEW("에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");

    private final String message;

    OutputMsg(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}