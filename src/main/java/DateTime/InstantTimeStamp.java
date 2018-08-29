package DateTime;

import sun.security.jca.GetInstance;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.*;

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
 * LocalDateTime
 * DateTimeFormatter
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

        // Current date and time
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println("=========== java.time.LocalDateTime ISO Dates =============");
        // Format as basic ISO date format
        String asBasicIsoDate = dateTime.format(DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println("BASIC ISO DATE : " + asBasicIsoDate);

        // Format as ISO week date
        String asIsoWeekDate = dateTime.format(DateTimeFormatter.ISO_WEEK_DATE);
        System.out.println("ISO WEEK DATE : " + asIsoWeekDate);

        // Format ISO date time
        String asIsoDateTime = dateTime.format(DateTimeFormatter.ISO_DATE_TIME);
        System.out.println("ISO DATE TIME : " + asIsoDateTime);

        // Use a custom pattern: day / month / year
        String asCustomPattern = dateTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        System.out.println("Custom pattern : " + asCustomPattern);


        System.out.println("=========== DateTimeFormatter  LocalizedDateTime=============");
        // Use short US date/time formatting
        DateTimeFormatter formatter1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).withLocale(new Locale("en-US"));
        String usDateTime = dateTime.format(formatter1);
        System.out.println("US locale : " + usDateTime);

        System.out.println("=========== java.time.Instant =============");
        // Get the current time
        Instant instant = Instant.now();
        // Output format is ISO-8601
        System.out.println(" instant :  "+instant);

        ZoneId zoneid1 = ZoneId.of("Europe/Copenhagen");
        ZoneId zoneid2 = ZoneId.of("Asia/Tokyo");
        LocalTime id1 = LocalTime.now(zoneid1);
        LocalTime id2 = LocalTime.now(zoneid2);
        System.out.println("Europe/Copenhagen  : "+id1);
        System.out.println("Asia/Tokyo  : "+id2);
        // get clock with desired time-zone

        /*"=======This part doesnt work - Clock.system(ZoneId.of(\"America/Chicago\") ")*/
        Clock clock = Clock.system(ZoneId.of("America/Chicago"));
        Instant instant1 = Instant.now(clock);
        System.out.println("instant1 :  "+instant1);

        Clock clock1 = Clock.system(ZoneId.of("Europe/Copenhagen"));
        Instant instant2 = Instant.now(clock1);
        System.out.println("instant2 :  "+instant2);

        /*===============================================================================*/
        TimeZone timeZone1 = TimeZone.getTimeZone("America/Los_Angeles");
        TimeZone timeZone2 = TimeZone.getTimeZone("Europe/Copenhagen");

        Calendar calendar = new GregorianCalendar();
        calendar.setTimeZone(timeZone1);
        ;
        System.out.println("timeLA   = " + calendar.getTime());
        System.out.println("hour     = " + calendar.get(Calendar.HOUR_OF_DAY));

        TimeZone timeZoneLA = TimeZone.getTimeZone("America/Los_Angeles");
        ZoneId zoneIdLA = timeZoneLA.toZoneId();
        System.out.println("ZoneId from custom 'LA' TimeZone: " + zoneIdLA);

        System.out.println("=========== LocalDate =============");
        LocalDate currentDate = LocalDate.now();
        System.out.println(currentDate);

        System.out.println("=============  ==========");
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


        ZoneId minsk = ZoneId.ofOffset("GMT", ZoneOffset.ofHours(+3));
        ZoneId berlin = ZoneId.of("Europe/Berlin");

// Current date and time
        LocalDateTime dateTime2 = LocalDateTime.now();
        System.out.println("Here : " + dateTime2);
        System.out.println("=============ZonedDateTime =========");

        ZonedDateTime minskDateTime = ZonedDateTime.of(dateTime2, minsk);
        System.out.println("Minsk : " + minskDateTime);




    }
}
