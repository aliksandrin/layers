package com.javaextreme.ui;

import com.javaextreme.service.StringValidatorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;

public class StringReceiverUIImpl implements StringReceiverUI{
    private static final Logger logger = LoggerFactory.getLogger(StringReceiverUIImpl.class);
    private StringValidatorService stringValidatorService;

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
            result = stringValidatorService.validate(dateString);
            logger.info("The day of the week for {} date is {}.", dateString, result);
        } catch (ParseException e) {
            logger.error("Your string doesn't match required date format! Please try again later ;)", 1);
        }
    }

    public void setStringValidatorService(StringValidatorService stringValidatorService) {
        this.stringValidatorService = stringValidatorService;
    }

    public StringValidatorService getStringValidator() {
        return stringValidatorService;
    }
}
