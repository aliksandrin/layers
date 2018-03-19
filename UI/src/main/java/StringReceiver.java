import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;

public class StringReceiver {
    private static final Logger logger = LoggerFactory.getLogger(StringReceiver.class);

    public static void main(String[] args) throws ParseException {
        // there dd.MM.yyyy must be
        String dateString;
        String result;
        try {
            dateString = args[0];
            logger.info("Validation started...");
            result = StringValidator.validate(dateString);
        } catch (ParseException e) {
            throw new ParseException(e.getMessage(), 1);
        }
        catch (NullPointerException | ArrayIndexOutOfBoundsException e){
            throw new NullPointerException("Null is not valid argument. Please try again later ;)");
        }
        logger.info(String.format("The day of the week for %s date is %s.", dateString, result));
    }
}
