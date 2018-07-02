package DateTime;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by mkoduri on 7/2/2018.
 *
 * Instant class : This class is immutable and thread-safe.
 *
 * package : java.time.Instant  , java.time.LocalDate; java.time.LocalDateTime;
 *
 * since java 1.8
 *
 * LocalDate
 * LocalTime
 * ZoneId
 *
 * https://docs.oracle.com/javase/8/docs/api/java/time/LocalTime.html
 * https://docs.oracle.com/javase/8/docs/api/java/time/ZoneId.html
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


        System.out.println("=========== LocalDate =============");
        // 1979-02-15
        LocalDate feb15th = LocalDate.of(1979, Month.FEBRUARY, 15);
        System.out.println(feb15th);

        // Days values start at 1 (2000-09-01)
        LocalDate sept1st = LocalDate.of(2000, 9, 1);
        System.out.println(sept1st);

        System.out.println("=========== LocalDate is used to get specific day of the year =============");
        // The 256th day of 2015
        LocalDate programmerDay = LocalDate.ofYearDay(2015, 256);
        System.out.println(programmerDay);


        System.out.println("=========== LocalDate is used to get specific day of the year =============");
        // The 183 day of 2018
        LocalDate programmerDay1 = LocalDate.ofYearDay(2018, 183);
        System.out.println(programmerDay1);
        System.out.println(programmerDay1.getMonth() + "   "+ programmerDay1.getMonthValue());



    }
}
