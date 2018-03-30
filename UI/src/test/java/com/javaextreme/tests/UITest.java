package com.javaextreme.tests;

import com.javaextreme.service.Service;
import com.javaextreme.service.ServiceImpl;
import com.javaextreme.ui.UI;
import com.javaextreme.ui.UIImpl;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Collection;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(Parameterized.class)
public class UITest extends OutputStreamTest{
    private UI ui;
    private Service service;
    private String day;
    private String dateString;

    public UITest(String day, String dateString) {
        this.day = day;
        this.dateString = dateString;
    }

    @Before
    public void setUp() {
        service = mock(ServiceImpl.class);
        ui = new UIImpl();
        ui.setService(service);

    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"monday", "12.03.2018"},
                {"tuesday", "13.03.2018"},
                {"wednesday", "14.03.2018"},
                {"thursday", "15.03.2018"},
                {"friday", "16.03.2018"},
                {"saturday", "17.03.2018"},
                {"sunday", "18.03.2018"}
        });
    }



    @Test
    public void main() throws ParseException {
        when(service.getDayOfWeek(dateString)).thenReturn(day);
        ui.showDayOfWeek(dateString);
        String expected = "The day of the week for " + dateString + " date is " + day + ".";
        Assert.assertThat(output.toString(), CoreMatchers.containsString(expected));
        verify(service).getDayOfWeek(dateString);
    }

    @Test
    public void mainNull() throws ParseException {
        when(service.getDayOfWeek("some")).thenThrow(ParseException.class);
        ui.showDayOfWeek("some");
        Assert.assertThat(output.toString(),
                CoreMatchers.containsString("Your string doesn't match required date"));
        verify(service).getDayOfWeek("some");
    }
}