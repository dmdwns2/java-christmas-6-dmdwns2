package christmas.view;

import christmas.enums.Calendar;
import christmas.enums.InputMsg;

public class OutputView {
    public void printIntro() {
        System.out.println(InputMsg.INTRO.getMessage());
    }

    public void printReadDate() {
        System.out.println(InputMsg.READ_DATE.getMessage());
    }

    public void printReadOrder() {
        System.out.println(InputMsg.READ_ORDER.getMessage());
    }

    public void printPreview(Calendar month, int date) {
        System.out.println(month.getMonth() + InputMsg.MONTH.getMessage() +
                date + InputMsg.DAY.getMessage() + InputMsg.PREVIEW.getMessage());
    }
}