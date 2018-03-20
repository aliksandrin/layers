package com.javaextreme.ui;

import com.javaextreme.service.StringValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;

public class StringReceiver {
    private static final Logger logger = LoggerFactory.getLogger(StringReceiver.class);
    private static StringValidator stringValidator;

    public void receive(String[] args) {
        // there dd.MM.yyyy must be

        if (args.length == 0) {
            logger.error("You didn't enter a date. Please try again later ;)");
            return;
        }

        String dateString;
        String result;
        try {
            dateString = args[0];
            logger.info("Validation started...");
            result = stringValidator.validate(dateString);
            logger.info("The day of the week for {} date is {}.", dateString, result);
        } catch (ParseException e) {
            logger.error(e.getMessage());
        }
    }

    public void setStringValidator(StringValidator stringValidator) {
        StringReceiver.stringValidator = stringValidator;
    }
}
