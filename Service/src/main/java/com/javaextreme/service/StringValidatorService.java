package com.javaextreme.service;

import com.javaextreme.dao.StringDAO;

import java.text.ParseException;

public interface StringValidatorService {
    void setStringDAO(StringDAO stringDAO);
    String validate(String line) throws ParseException;
}
