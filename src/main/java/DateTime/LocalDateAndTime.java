package DateTime;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;

/**
 * Created by mkoduri on 7/2/2018.
 *
 * With this api you can get Date, time and more importantly Local Time (current).
 *
 * https://docs.oracle.com/javase/8/docs/api/java/time/LocalTime.html
 * https://docs.oracle.com/javase/8/docs/api/java/time/ZoneId.html
 *
 */
public class LocalDateAndTime {

    public static void main(String[] args) {

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


        System.out.println("=========== LocalTime stores a time without a date =============");
        //LocalTime stores a time without a date.
        LocalTime currentTime = LocalTime.now(); // current time
        System.out.println("currentTime : "+currentTime);

        ZoneId zone1 = ZoneId.of("Europe/Berlin");
        LocalTime currentTime1 = LocalTime.now(zone1);
        System.out.println("currentTime1 in Berlin : "+ currentTime1);

        LocalTime midday = LocalTime.of(12, 0); // 12:00
        System.out.println("midday : "+midday);

        LocalTime afterMidday = LocalTime.of(13, 30, 45); // 13:30:45
        System.out.println("afterMidday : "+afterMidday);

        // 12345th second of day (03:25:45)
        LocalTime fromSecs = LocalTime.ofSecondOfDay(12345); // (valid values 0 - 86399)
        System.out.println("fromSecs : "+fromSecs);


    }
}
