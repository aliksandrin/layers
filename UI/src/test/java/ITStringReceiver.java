import categories.IntegrationTest;
import com.javaextreme.ui.StringReceiver;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category(IntegrationTest.class)
public class ITStringReceiver {

    @Test(expected = NullPointerException.class)
    public void mainNull() {
        StringReceiver.main(null);
    }

    @Test
    public void mainWithArgument()  {
        StringReceiver.main(new String[]{"13.03.2018"});
    }

    @Test
    public void mainWithSimpleString() {
        StringReceiver.main(new String[]{"SomeString"});
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void mainNullString() {
        StringReceiver.main(new String[]{});
    }
}