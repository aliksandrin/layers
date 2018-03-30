package com.javaextreme.tests;

import com.javaextreme.dao.DAO;
import com.javaextreme.dao.DAOImpl;
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
public class DAOImplTest {
    private DAO DAO;
    private String day;
    private Date date;

    public DAOImplTest(String day, Date date) {
        this.day = day;
        this.date = date;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"monday", new GregorianCalendar(2018, 2, 12).getTime()},
                {"tuesday", new GregorianCalendar(2018, 2, 13).getTime()},
                {"wednesday", new GregorianCalendar(2018, 2, 14).getTime()},
                {"thursday", new GregorianCalendar(2018, 2, 15).getTime()},
                {"friday", new GregorianCalendar(2018, 2, 16).getTime()},
                {"saturday", new GregorianCalendar(2018, 2, 17).getTime()},
                {"sunday", new GregorianCalendar(2018, 2, 18).getTime()},
        });
    }

    @Before
    public void setUp() {
        DAO = new DAOImpl();
    }

    @Test
    public void get(){
        Assert.assertEquals(day, DAO.get(date));
    }
}