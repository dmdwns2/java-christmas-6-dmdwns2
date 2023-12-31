package christmas.enums;

public enum ErrMsg {
    EMPTY_INPUT("[ERROR] 내용을 입력해 주세요.\n"),
    INVALID_ORDER("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.\n"),
    INVALID_DATE("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.\n");

    private final String message;

    ErrMsg(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}