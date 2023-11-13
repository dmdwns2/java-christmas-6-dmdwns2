package christmas.view;

import christmas.enums.ErrMsg;
import christmas.enums.InputMsg;

public class OutputView {
    public void emptyInput() {
        System.out.println(ErrMsg.EMPTY_INPUT);
    }

    public void invalidOrder() {
        System.out.println(ErrMsg.INVALID_ORDER);
    }

    public void invalidDate() {
        System.out.println(ErrMsg.INVALID_DATE);
    }

    public void printReadDate() {
        System.out.println(InputMsg.READ_DATE);
    }

    public void printReadOrder() {
        System.out.println(InputMsg.READ_ORDER);
    }
}