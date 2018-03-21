package com.javaextreme.service;

import com.javaextreme.dao.StringDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class StringValidatorServiceImpl implements StringValidatorService{
    private static final Logger logger = LoggerFactory.getLogger(StringValidatorServiceImpl.class);
    private StringDAO stringDAO;

    public void setStringDAOImpl(StringDAO stringDAO) {
        this.stringDAO = stringDAO;
    }

    public String validate(String dateString) throws ParseException {
        String format = "dd.MM.yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format, Locale.ENGLISH);
        simpleDateFormat.setLenient(false);

        Date date;
        try {
            date = simpleDateFormat.parse(dateString);
        } catch (ParseException e) {
            throw new ParseException("Your string doesn't match required date format! Please try again later ;)", 1);
        }

        logger.info("Your date is valid, please wait...");

        return stringDAO.get(date);
    }
}
