package com.javaextreme.service;

import com.javaextreme.dao.DAO;

import java.text.ParseException;

public interface Service {
    void setDAO(DAO DAO);
    String getDayOfWeek(String line) throws ParseException;
    DAO getDAO();
}
