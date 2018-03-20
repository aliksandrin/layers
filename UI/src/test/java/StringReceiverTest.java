import categories.JunitTests;
import com.javaextreme.service.StringValidator;
import com.javaextreme.ui.StringReceiver;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.slf4j.Logger;

import java.text.ParseException;

import static org.mockito.Matchers.any;
import static org.powermock.api.mockito.PowerMockito.*;

@Category(JunitTests.class)
@RunWith(PowerMockRunner.class)
@PrepareForTest(StringValidator.class)
public class StringReceiverTest {

    @Test
    public void mainWithArgument() throws ParseException {
        mockStatic(Logger.class);
        mockStatic(StringValidator.class);
        when(StringValidator.validate("13.03.2018")).thenReturn("tuesday");

        StringReceiver.main(new String[]{"13.03.2018"});
        verifyStatic();
    }

    @Test(expected = NullPointerException.class)
    public void mainWithNoArgument() {
        mockStatic(Logger.class);
        StringReceiver.main(null);
        verifyStatic();
    }

    @Test
    public void mainSimpleString() throws ParseException {
        mockStatic(Logger.class);
        mockStatic(StringValidator.class);
        when(StringValidator.validate(any())).thenThrow(new ParseException("Your string doesn't match required date format! Please try again later ;)", 1));

        StringReceiver.main(new String[]{"SomeString"});
        verifyStatic();
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void mainNullString() {
        mockStatic(Logger.class);
        StringReceiver.main(new String[]{});
        verifyStatic();
    }
}