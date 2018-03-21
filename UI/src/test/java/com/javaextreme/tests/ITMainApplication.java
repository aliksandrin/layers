package com.javaextreme.tests;

import com.javaextreme.tests.categories.IntegrationTest;
import com.javaextreme.ui.MainApplication;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@Category(IntegrationTest.class)
@RunWith(Parameterized.class)
public class ITMainApplication extends OutputStreamTest{
    private String dateString;
    private String day;

    public ITMainApplication(String day, String dateString) {
        this.day = day;
        this.dateString = dateString;
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
        MainApplication.main(new String[]{dateString});
        Assert.assertThat(output.toString(), CoreMatchers.containsString(expected));
    }

    @Test()
    public void mainNull() {
        MainApplication.main(new String[]{});
        Assert.assertThat(output.toString(), CoreMatchers.containsString("You didn't enter a date. Please try again later ;)"));
    }

    @Test()
    public void mainSomeString() {
        MainApplication.main(new String[]{"some string"});
        Assert.assertThat(output.toString(), CoreMatchers.containsString("Your string doesn't match required date format! Please try again later ;)"));
    }
}