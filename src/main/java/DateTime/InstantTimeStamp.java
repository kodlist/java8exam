package DateTime;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by mkoduri on 7/2/2018.
 *
 * Instant class : This class is immutable and thread-safe.
 *
 * package : java.time.Instant
 */
public class InstantTimeStamp {

    public static void main(String[] args) {

        System.out.println("=========== java.util.Date =============");
        DateFormat dateFormat1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        System.out.println(dateFormat1.format(date));

        System.out.println("=========== java.util.Calendar =============");
        DateFormat dateFormat2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        System.out.println(dateFormat2.format(cal.getTime()));

        System.out.println("=========== java.time.LocalDateTime =============");
        DateTimeFormatter dateFormat3 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dateFormat3.format(now));

        System.out.println("=========== java.time.Instant =============");
        // Get the current time
        Instant instant = Instant.now();
        // Output format is ISO-8601
        System.out.println(instant);
    }
}
