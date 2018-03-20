package com.javaextreme.tests;

import categories.JunitTests;
import com.javaextreme.service.StringValidator;
import com.javaextreme.ui.StringReceiver;
import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collection;

import static org.mockito.Mockito.*;

@Category(JunitTests.class)
@RunWith(Parameterized.class)
public class StringReceiverTest {
    private StringReceiver stringReceiver;
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    private StringValidator stringValidator;
    private String day;
    private String dateString;

    public StringReceiverTest(String day, String dateString) {
        this.day = day;
        this.dateString = dateString;
    }

    @Before
    public void setUp() {
        System.setOut(new PrintStream(output));
        stringValidator = mock(StringValidator.class);
        stringReceiver = new StringReceiver();
        stringReceiver.setStringValidator(stringValidator);

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

    @After
    public void clear(){
        System.setOut(null);
    }

    @Test
    public void main() throws Exception {
        when(stringValidator.validate(dateString)).thenReturn(day);
        stringReceiver.receive(new String[]{dateString});
        String expected = "The day of the week for " + dateString + " date is " + day + ".";
        Assert.assertThat(output.toString(), CoreMatchers.containsString(expected));
        verify(stringValidator).validate(dateString);
        output.close();
    }

    @Test
    public void mainNull() {
        stringReceiver.receive(new String[]{});
        Assert.assertThat(output.toString(), CoreMatchers.containsString("You didn't enter a date. Please try again later ;)"));
    }
}