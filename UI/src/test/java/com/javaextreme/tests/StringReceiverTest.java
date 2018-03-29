package com.javaextreme.tests;

import com.javaextreme.service.StringValidatorService;
import com.javaextreme.service.StringValidatorServiceImpl;
import com.javaextreme.ui.StringReceiverUI;
import com.javaextreme.ui.StringReceiverUIImpl;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.InjectMocks;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Collection;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.mock;

@RunWith(Parameterized.class)
public class StringReceiverTest extends OutputStreamTest{
    @InjectMocks
    private StringReceiverUI stringReceiverUI;
    private StringValidatorService stringValidatorService;
    private String day;
    private String dateString;

    public StringReceiverTest(String day, String dateString) {
        this.day = day;
        this.dateString = dateString;
    }

    @Before
    public void setUp() throws Exception{
        stringValidatorService = mock(StringValidatorServiceImpl.class);
        stringReceiverUI = new StringReceiverUIImpl();
        stringReceiverUI.setStringValidatorService(stringValidatorService);

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
        when(stringValidatorService.validate(dateString)).thenReturn(day);
        stringReceiverUI.receive(new String[]{dateString});
        String expected = "The day of the week for " + dateString + " date is " + day + ".";
        Assert.assertThat(output.toString(), CoreMatchers.containsString(expected));
        verify(stringValidatorService).validate(dateString);
    }

    @Test
    public void mainNull() {
        stringReceiverUI.receive(new String[]{});
        Assert.assertThat(output.toString(), CoreMatchers.containsString("You didn't enter a date. Please try again later ;)"));
    }
}