package com.javaextreme.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StringDAOImpl implements StringDAO{
    private static final Logger logger = LoggerFactory.getLogger(StringDAOImpl.class);

    public String get(Date date) {
        logger.info("Discovering the week of the day...");
        String day = new SimpleDateFormat("EEEEE").format(date);
        return day.toLowerCase();
    }
}
