import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.*;

public class WeekDay {
    private static final Logger logger = LoggerFactory.getLogger(WeekDay.class);

    public static String get(Date date) {
        logger.info("Discovering the week of the day...");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        switch (day) {
            case 1:
                return "sunday";
            case 2:
                return "monday";
            case 3:
                return "tuesday";
            case 4:
                return "wednesday";
            case 5:
                return "thursday";
            case 6:
                return "friday";
            case 7:
                return "saturday";
            default:
                return "unknown day of week";
        }
    }
}
