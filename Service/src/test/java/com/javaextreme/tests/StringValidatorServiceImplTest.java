package com.javaextreme.tests;

import com.javaextreme.dao.StringDAOImpl;
import com.javaextreme.service.StringValidatorServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.mockito.Mockito.*;

@RunWith(Parameterized.class)
public class StringValidatorServiceImplTest {
    @Rule
    public ExpectedException thrown= ExpectedException.none();
    private StringValidatorServiceImpl stringValidator;
    private String day;
    private Date date;
    private String dateString;
    private StringDAOImpl stringDAOImpl;

    public StringValidatorServiceImplTest(String day, Date date, String dateString) {
        this.day = day;
        this.date = date;
        this.dateString = dateString;
    }

    @Before
    public void setUp() {
        stringDAOImpl = mock(StringDAOImpl.class);
        stringValidator = new StringValidatorServiceImpl();
        stringValidator.setStringDAO(stringDAOImpl);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"monday", new GregorianCalendar(2018, 2, 12).getTime(), "12.03.2018"},
                {"tuesday", new GregorianCalendar(2018, 2, 13).getTime(), "13.03.2018"},
                {"wednesday", new GregorianCalendar(2018 , 2, 14).getTime(), "14.03.2018"},
                {"thursday", new GregorianCalendar(2018, 2, 15).getTime(), "15.03.2018"},
                {"friday", new GregorianCalendar(2018, 2, 16).getTime(), "16.03.2018"},
                {"saturday", new GregorianCalendar(2018, 2, 17).getTime(), "17.03.2018"},
                {"sunday", new GregorianCalendar(2018, 2, 18).getTime(), "18.03.2018"}
        });
    }

    @Test
    public void validate() throws ParseException {
        when(stringDAOImpl.get(date)).thenReturn(day);
        Assert.assertEquals(day, stringValidator.validate(dateString));
        verify(stringDAOImpl).get(date);
    }

    @Test
    public void validateNegative() throws ParseException{
        thrown.expect(ParseException.class);
        Assert.fail(stringValidator.validate("somestring"));
        verifyZeroInteractions(stringDAOImpl);
    }
}