package com.javaextreme.ui;

import com.javaextreme.service.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;

public class UIImpl implements UI {
    private static final Logger logger = LoggerFactory.getLogger(UIImpl.class);
    private Service service;

    public void showDayOfWeek(String date) {
        // there dd.MM.yyyy must be

        String result;
        try {
            result = service.getDayOfWeek(date);
            logger.info("The day of the week for {} date is {}.", date, result);
        } catch (ParseException e) {
            logger.error("Your string doesn't match required date format! Please try again later ;)", 1);
        }
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Service getService() {
        return service;
    }
}
