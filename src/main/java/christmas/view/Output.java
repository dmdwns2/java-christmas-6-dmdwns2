package christmas.view;

import christmas.enums.Calendar;

public interface Output {
    void printIntro();

    void printReadDate();

    void printReadOrder();

    void printPreview(Calendar calendar, int data);
}