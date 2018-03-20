package com.javaextreme.ui;

import com.javaextreme.dao.WeekDay;
import com.javaextreme.service.StringValidator;

public class MainApplication {

    public static void main(String[] args) {
        StringReceiver stringReceiver = new StringReceiver();
        StringValidator stringValidator = new StringValidator();
        stringValidator.setWeekDay(new WeekDay());
        stringReceiver.setStringValidator(stringValidator);

        stringReceiver.receive(args);
    }
}
