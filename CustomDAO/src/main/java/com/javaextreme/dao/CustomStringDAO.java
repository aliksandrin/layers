package com.javaextreme.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class CustomStringDAO implements StringDAO{

    private static final Logger logger = LoggerFactory.getLogger(CustomStringDAO.class);

    public String get(Date date) {
        logger.info("Discovering the week of the day (using CustomStringDAO)...");
        String day = new SimpleDateFormat("EEEEE", new Locale("ru")).format(date);
        return day.toLowerCase();
    }
}
