package com.javaextreme.tests;

import categories.JunitTests;
import com.javaextreme.dao.WeekDay;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

@Category(JunitTests.class)
@RunWith(Parameterized.class)
public class WeekDayTest {
    private WeekDay weekDay;
    private String day;
    private Date date;

    public WeekDayTest(String day, Date date) {
        this.day = day;
        this.date = date;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"monday", new Date(2018 - 1900, 2, 12)},
                {"tuesday", new Date(2018 - 1900, 2, 13)},
                {"wednesday", new Date(2018 - 1900, 2, 14)},
                {"thursday", new Date(2018 - 1900, 2, 15)},
                {"friday", new Date(2018 - 1900, 2, 16)},
                {"saturday", new Date(2018 - 1900, 2, 17)},
                {"sunday", new Date(2018 - 1900, 2, 18)},
        });
    }

    @Before
    public void setUp() {
        weekDay = new WeekDay();
    }

    @Test
    public void get(){
        //mockStatic(Logger.class);
        Assert.assertEquals(day, weekDay.get(date));
    }
}