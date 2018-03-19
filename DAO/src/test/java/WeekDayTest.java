import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.slf4j.Logger;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

import static org.powermock.api.mockito.PowerMockito.mockStatic;

@RunWith(Parameterized.class)
public class WeekDayTest {
    private String day;
    private Date date;

    public WeekDayTest(String day, Date date) {
        this.day = day;
        this.date = date;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"monday", new Date(2018 - 1900, 2, 12)},
                {"tuesday", new Date(2018 - 1900, 2, 13)},
                {"wednesday", new Date(2018 - 1900, 2, 14)},
                {"thursday", new Date(2018 - 1900, 2, 15)},
                {"friday", new Date(2018 - 1900, 2, 16)},
                {"saturday", new Date(2018 - 1900, 2, 17)},
                {"sunday", new Date(2018 - 1900, 2, 18)},
        });
    }

    @Test
    public void get(){
        mockStatic(Logger.class);
        Assert.assertEquals(day, WeekDay.get(date));
    }
}