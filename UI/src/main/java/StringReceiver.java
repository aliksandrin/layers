import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StringReceiver {
    private static final Logger logger = LoggerFactory.getLogger(StringReceiver.class);

    public static void main(String[] args) {
        // there dd.MM.yyyy must be
        PropertyConfigurator.configure("log4j.properties");

        if (args.length == 0) {
            logger.error("You didn't enter an argument. Please try again later ;)");
            System.exit(0);
        }
        String dateString = args[0];

        logger.info(String.format("Date string %s received.", dateString));
        String result = StringValidator.validate(dateString);
        logger.info(String.format("The day of the week for %s date is %s.", dateString, result));
    }
}
