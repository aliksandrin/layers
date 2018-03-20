package com.javaextreme.tests;

import categories.JunitTests;
import com.javaextreme.dao.WeekDay;
import com.javaextreme.service.StringValidator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

import static org.mockito.Mockito.*;

@Category(JunitTests.class)
@RunWith(Parameterized.class)
public class StringValidatorTest {
    private StringValidator stringValidator;
    private String day;
    private Date date;
    private String dateString;
    private WeekDay weekDay;

    public StringValidatorTest(String day, Date date, String dateString) {
        this.day = day;
        this.date = date;
        this.dateString = dateString;
    }

    @Before
    public void setUp() {
        weekDay = mock(WeekDay.class);
        stringValidator = new StringValidator();
        stringValidator.setWeekDay(weekDay);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"monday", new Date(2018 - 1900, 2, 12), "12.03.2018"},
                {"tuesday", new Date(2018 - 1900, 2, 13), "13.03.2018"},
                {"wednesday", new Date(2018 - 1900, 2, 14), "14.03.2018"},
                {"thursday", new Date(2018 - 1900, 2, 15), "15.03.2018"},
                {"friday", new Date(2018 - 1900, 2, 16), "16.03.2018"},
                {"saturday", new Date(2018 - 1900, 2, 17), "17.03.2018"},
                {"sunday", new Date(2018 - 1900, 2, 18), "18.03.2018"}
        });
    }

    @Test
    public void validate() throws ParseException {
        when(weekDay.get(date)).thenReturn(day);
        Assert.assertEquals(day, stringValidator.validate(dateString));
        verify(weekDay).get(date);
    }

    @Test(expected = ParseException.class)
    public void validateNegative() throws ParseException{
        Assert.fail(stringValidator.validate("somestring"));
        verifyZeroInteractions(weekDay);
    }
}