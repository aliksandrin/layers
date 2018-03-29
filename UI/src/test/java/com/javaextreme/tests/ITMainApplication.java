package com.javaextreme.tests;

import com.javaextreme.ui.StringReceiverUI;
import com.javaextreme.ui.StringReceiverUIImpl;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ITMainApplication extends OutputStreamTest {
    private ApplicationContext applicationContext;
    private StringReceiverUI stringReceiverUI;
    private String dateString;
    private String day;

    public ITMainApplication(String day, String dateString) {
        this.day = day;
        this.dateString = dateString;
    }

    @Before
    public void setUp() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext("/spring/test-application-context.xml");
        stringReceiverUI = applicationContext.getBean(StringReceiverUIImpl.class);
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

    @Test()
    public void main() {
        String expected = "The day of the week for " + dateString + " date is " + day + ".";
        stringReceiverUI.receive(new String[]{dateString});
        Assert.assertThat(output.toString(), CoreMatchers.containsString(expected));
    }

    @Test()
    public void mainNull() {
        stringReceiverUI.receive(new String[]{});
        Assert.assertThat(output.toString(), CoreMatchers.containsString("You didn't enter a date. Please try again later ;)"));
    }

    @Test()
    public void mainSomeString() {
        stringReceiverUI.receive(new String[]{"some string"});
        Assert.assertThat(output.toString(), CoreMatchers.containsString("Your string doesn't match required date format! Please try again later ;)"));
    }
}