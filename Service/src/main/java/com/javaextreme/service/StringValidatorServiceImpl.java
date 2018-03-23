package com.javaextreme.service;

import com.javaextreme.cache.Cacheable;
import com.javaextreme.dao.StringDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class StringValidatorServiceImpl implements StringValidatorService {
    private static final Logger logger = LoggerFactory.getLogger(StringValidatorServiceImpl.class);
    private StringDAO stringDAO;

    public void setStringDAO(StringDAO stringDAO) {
        this.stringDAO = stringDAO;
    }


    @Cacheable
    public String validate(String dateString) throws ParseException {
        String format = "dd.MM.yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format, Locale.ENGLISH);
        simpleDateFormat.setLenient(false);
        Date date = simpleDateFormat.parse(dateString);
        logger.info("Your date is valid, please wait...");

        return stringDAO.get(date);
    }
}
