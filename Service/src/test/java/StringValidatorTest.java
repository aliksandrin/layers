import categories.JunitTests;
import com.javaextreme.dao.WeekDay;
import com.javaextreme.service.StringValidator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.slf4j.Logger;

import java.text.ParseException;
import java.util.Date;

import static org.powermock.api.mockito.PowerMockito.*;

@Category(JunitTests.class)
@RunWith(PowerMockRunner.class)
@PrepareForTest(WeekDay.class)
public class StringValidatorTest {

    @Before
    public void setUp() {
        mockStatic(Logger.class);
        mockStatic(WeekDay.class);
    }

    @Test
    public void validateMonday() throws ParseException {
        when(WeekDay.get(new Date(2018 - 1900, 2, 12))).thenReturn("monday");

        Assert.assertEquals("monday", StringValidator.validate("12.03.2018"));
        verifyStatic();
    }

    @Test
    public void validateTuesday() throws ParseException {
        when(WeekDay.get(new Date(2018 - 1900, 2, 13))).thenReturn("tuesday");

        Assert.assertEquals("tuesday", StringValidator.validate("13.03.2018"));
        verifyStatic();
    }

    @Test
    public void validateWednesday() throws ParseException {
        when(WeekDay.get(new Date(2018 - 1900, 2, 14))).thenReturn("wednesday");

        Assert.assertEquals("wednesday", StringValidator.validate("14.03.2018"));
        verifyStatic();
    }

    @Test
    public void validateThursday() throws ParseException {
        when(WeekDay.get(new Date(2018 - 1900, 2, 15))).thenReturn("thursday");

        Assert.assertEquals("thursday", StringValidator.validate("15.03.2018"));
        verifyStatic();
    }

    @Test
    public void validateFriday() throws ParseException {
        when(WeekDay.get(new Date(2018 - 1900, 2, 16))).thenReturn("friday");

        Assert.assertEquals("friday", StringValidator.validate("16.03.2018"));
        verifyStatic();
    }

    @Test
    public void validateSaturday() throws ParseException {
        when(WeekDay.get(new Date(2018 - 1900, 2, 17))).thenReturn("saturday");

        Assert.assertEquals("saturday", StringValidator.validate("17.03.2018"));
        verifyStatic();
    }

    @Test
    public void validateSunday() throws ParseException {
        when(WeekDay.get(new Date(2018 - 1900, 2, 18))).thenReturn("sunday");

        Assert.assertEquals("sunday", StringValidator.validate("18.03.2018"));
        verifyStatic();
    }

    @Test(expected = ParseException.class)
    public void validateSlashFormat() throws ParseException {
        when(WeekDay.get(new Date(2018 - 1900, 2, 18))).thenReturn("sunday");

        Assert.assertEquals("sunday", StringValidator.validate("18/03/2018"));
        verifyStatic();
    }

    @Test(expected = ParseException.class)
    public void validateSemicolonFormat() throws ParseException {
        when(WeekDay.get(new Date(2018 - 1900, 2, 18))).thenReturn("sunday");

        Assert.assertEquals("sunday", StringValidator.validate("18:03:2018"));
        verifyStatic();
    }
}