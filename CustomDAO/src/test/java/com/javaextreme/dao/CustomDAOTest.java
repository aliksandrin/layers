package com.javaextreme.dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;

@RunWith(Parameterized.class)
public class CustomDAOTest {
    private DAO DAO;
    private String day;
    private Date date;

    public CustomDAOTest(String day, Date date) {
        this.day = day;
        this.date = date;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"понедельник", new GregorianCalendar(2018, 2, 12).getTime()},
                {"вторник", new GregorianCalendar(2018, 2, 13).getTime()},
                {"среда", new GregorianCalendar(2018, 2, 14).getTime()},
                {"четверг", new GregorianCalendar(2018, 2, 15).getTime()},
                {"пятница", new GregorianCalendar(2018, 2, 16).getTime()},
                {"суббота", new GregorianCalendar(2018, 2, 17).getTime()},
                {"воскресенье", new GregorianCalendar(2018, 2, 18).getTime()},
        });
    }

    @Before
    public void setUp() {
        DAO = new CustomDAO();
    }

    @Test
    public void get(){
        Assert.assertEquals(day, DAO.get(date));
    }
}