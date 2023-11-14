package christmas.view;

import christmas.enums.Calendar;
import christmas.enums.OutputMsg;

public class OutputView implements Output {
    @Override
    public void printIntro() {
        System.out.println(OutputMsg.INTRO.getMessage());
    }

    @Override
    public void printReadDate() {
        System.out.println(OutputMsg.READ_DATE.getMessage());
    }

    @Override
    public void printReadOrder() {
        System.out.println(OutputMsg.READ_ORDER.getMessage());
    }

    @Override
    public void printPreview(Calendar month, int date) {
        System.out.println(month.getMonth() + OutputMsg.MONTH.getMessage() +
                date + OutputMsg.DAY.getMessage() + OutputMsg.PREVIEW.getMessage());
        System.out.println();
    }
}