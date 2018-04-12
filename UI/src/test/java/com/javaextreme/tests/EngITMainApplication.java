package com.javaextreme.tests;

import com.javaextreme.ui.MainApplication;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContextManager;
import org.springframework.test.context.junit4.rules.SpringClassRule;
import org.springframework.test.context.junit4.rules.SpringMethodRule;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
@ContextConfiguration(locations = {"classpath*:spring/application-context.xml",
        "classpath*:spring/dao-context.xml", "classpath*:spring/service-context.xml", "classpath*:spring/cache-context.xml"})
public class EngITMainApplication extends OutputStreamTest {
    private TestContextManager testContextManager;

    @ClassRule
    public static final SpringClassRule SPRING_CLASS_RULE = new SpringClassRule();

    @Rule
    public final SpringMethodRule springMethodRule = new SpringMethodRule();

    private String dateString;
    private String day;

    public EngITMainApplication(String day, String dateString) {
        this.day = day;
        this.dateString = dateString;
    }

    @Before
    public void setUpContext() throws Exception {
        testContextManager = new TestContextManager(getClass());
        testContextManager.prepareTestInstance(this);
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
        String result = output.toString();
        Assert.assertThat(result, CoreMatchers.containsString(expected));
    }

    @Test()
    public void mainNull() {
        String expected = "You didn't enter a date. Please try again later ;)";
        MainApplication.main(new String[]{});
        String result = output.toString();
        Assert.assertThat(result, CoreMatchers.containsString(expected));
    }

    @Test()
    public void mainSomeString() {
        String expected = "Your string doesn't match required date format! Please try again later ;)";
        MainApplication.main(new String[]{"some string"});
        String result = output.toString();
        Assert.assertThat(result, CoreMatchers.containsString(expected));
    }

    @Test()
    public void mainWithCache() {
        String expected = "The day of the week for " + dateString + " date is " + day + ".";
        MainApplication.main(new String[]{dateString});
        String result = output.toString();
        Assert.assertThat(result, CoreMatchers.containsString(expected));
        Assert.assertThat(result, CoreMatchers.containsString("We'll put [" + dateString + "] in cache!"));
    }
}