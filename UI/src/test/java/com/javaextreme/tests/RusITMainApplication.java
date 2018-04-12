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
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.MethodMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContextManager;
import org.springframework.test.context.junit4.rules.SpringClassRule;
import org.springframework.test.context.junit4.rules.SpringMethodRule;

import java.util.Arrays;
import java.util.Collection;

@DirtiesContext(methodMode = MethodMode.BEFORE_METHOD)
@RunWith(Parameterized.class)
@ContextConfiguration(locations = {"classpath*:spring/*-context.xml"})
public class RusITMainApplication extends OutputStreamTest {
    private TestContextManager testContextManager;

    @ClassRule
    public static final SpringClassRule SPRING_CLASS_RULE = new SpringClassRule();

    @Rule
    public final SpringMethodRule springMethodRule = new SpringMethodRule();

    private String dateString;
    private String day;

    public RusITMainApplication(String day, String dateString) {
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
                {"понедельник", "12.03.2018"},
                {"вторник", "13.03.2018"},
                {"среда", "14.03.2018"},
                {"четверг", "15.03.2018"},
                {"пятница", "16.03.2018"},
                {"суббота", "17.03.2018"},
                {"воскресенье", "18.03.2018"}
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