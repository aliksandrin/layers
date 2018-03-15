import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class StringValidator {
    private static final Logger logger = LoggerFactory.getLogger(StringValidator.class);

    public static String validate(String dateString) {
        logger.info("Validation started...");

        String format = "dd.MM.yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format, Locale.ENGLISH);
        simpleDateFormat.setLenient(false);


        Date date = null;
        try {
            date = simpleDateFormat.parse(dateString);
            logger.info("Your date is valid, please wait...");
        } catch (ParseException e) {
            logger.error("Your string doesn't match required date format! Please try again later ;)");
            System.exit(0);
        }

        String dayOfWeek = WeekDay.get(date);


        return dayOfWeek;
    }
}
