import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;

public class StringReceiver {
    private static final Logger logger = LoggerFactory.getLogger(StringReceiver.class);

    public static void main(String[] args) {
        // there dd.MM.yyyy must be

        String dateString = null;
        try {
            dateString = args[0];
        } catch (ArrayIndexOutOfBoundsException e) {
            logger.error("Null is not valid argument. Please try again later ;)");
            System.exit(1);
        }
        logger.info(String.format("Date string %s received.", dateString));

        String result = null;
        try {
            result = StringValidator.validate(dateString);
        } catch (ParseException e) {
            logger.error(e.getMessage());
            System.exit(1);
        }
        logger.info(String.format("The day of the week for %s date is %s.", dateString, result));
    }
}
