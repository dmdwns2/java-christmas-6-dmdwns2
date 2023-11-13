package christmas.view;

import christmas.enums.Calendar;
import christmas.enums.InputMsg;

public class OutputView implements Output {
    @Override
    public void printIntro() {
        System.out.println(InputMsg.INTRO.getMessage());
    }

    @Override
    public void printReadDate() {
        System.out.println(InputMsg.READ_DATE.getMessage());
    }

    @Override
    public void printReadOrder() {
        System.out.println(InputMsg.READ_ORDER.getMessage());
    }

    @Override
    public void printPreview(Calendar month, int date) {
        System.out.println(month.getMonth() + InputMsg.MONTH.getMessage() +
                date + InputMsg.DAY.getMessage() + InputMsg.PREVIEW.getMessage());
    }
}