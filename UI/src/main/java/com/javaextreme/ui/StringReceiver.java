package com.javaextreme.ui;

import com.javaextreme.service.StringValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;

public class StringReceiver {
    private static final Logger logger = LoggerFactory.getLogger(StringReceiver.class);

    public static void main(String[] args) {
        // there dd.MM.yyyy must be

        String dateString;
        String result;
        try {
            dateString = args[0];
            logger.info("Validation started...");
            result = StringValidator.validate(dateString);
            logger.info("The day of the week for {} date is {}.", dateString, result);
        } catch (ParseException e) {
            logger.error(e.getMessage());
        }
    }
}
