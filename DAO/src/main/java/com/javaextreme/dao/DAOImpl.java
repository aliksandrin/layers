package com.javaextreme.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DAOImpl implements DAO {
    private static final Logger logger = LoggerFactory.getLogger(DAOImpl.class);

    public String get(Date date) {
        logger.info("Discovering the week of the day...");
        String day = new SimpleDateFormat("EEEEE").format(date);
        return day.toLowerCase();
    }
}
