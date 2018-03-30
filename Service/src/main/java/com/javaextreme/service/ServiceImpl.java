package com.javaextreme.service;

import com.javaextreme.cache.Cacheable;
import com.javaextreme.dao.DAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ServiceImpl implements Service {
    private static final Logger logger = LoggerFactory.getLogger(ServiceImpl.class);
    private DAO DAO;

    public void setDAO(DAO DAO) {
        this.DAO = DAO;
    }

    public DAO getDAO() {
        return DAO;
    }

    @Cacheable
    public String getDayOfWeek(String dateString) throws ParseException {
        String format = "dd.MM.yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format, Locale.ENGLISH);
        simpleDateFormat.setLenient(false);
        Date date = simpleDateFormat.parse(dateString);
        logger.info("Your date is valid, please wait...");

        return DAO.get(date);
    }
}
