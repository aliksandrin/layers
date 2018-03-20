package com.javaextreme.tests;

import categories.IntegrationTest;
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

@Category(IntegrationTest.class)
@RunWith(Parameterized.class)
public class ITMainApplication {
    private ByteArrayOutputStream output;
    private String dataString;
    private String day;

    public ITMainApplication(String day, String dataString) {
        this.dataString = dataString;
        this.day = day;
    }

    @Before
    public void setUp() {
        output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
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
        String expected = "The day of the week for " + dataString + " date is " + day + ".";
        Assert.assertThat(output.toString(), CoreMatchers.containsString(expected));
    }
}