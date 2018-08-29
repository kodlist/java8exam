package DateTime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * Created by mkoduri on 7/2/2018.
 *
 * With this api you can get Date, time and more importantly Local Time (current).
 *
 * since java 1.8
 *
 * LocalDate
 * LocalTime
 * ZoneId
 *
 * https://docs.oracle.com/javase/8/docs/api/java/time/LocalTime.html
 * https://docs.oracle.com/javase/8/docs/api/java/time/ZoneId.html
 *
 */
public class LocalDateAndTime {

    public static void main(String[] args) {

        System.out.println("=========== LocalDate =============");

        LocalDate ldate = LocalDate.now();
        System.out.println("current date only : "+ldate);
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


        System.out.println("============= LocalDateTime  Parsing date and time  ");
        String str = "1986-04-08 12:30";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(str, formatter);
        //System.out.println(dateTime);
        System.out.println("============= LocalDateTime  Formatting date and time ");

        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dateTime1 = LocalDateTime.of(1986, Month.APRIL, 8, 12, 30);
        String formattedDateTime = dateTime1.format(formatter1); // "1986-04-08 12:30"

        java.time.ZonedDateTime zdnTime = ZonedDateTime.now();
        System.out.println(" zoneddatetime :  "+zdnTime);
        System.out.println("ZonedDateTime now in Berlin :  "+ZonedDateTime.now( ZoneId.of("Europe/Berlin")));


        LocalDateTime ld1 = LocalDateTime.of(2015, Month.NOVEMBER, 1, 2, 0);
        ZonedDateTime zd1 = ZonedDateTime.of(ld1, ZoneId.of("US/Eastern"));

        LocalDateTime ld2 = LocalDateTime.of(2015, Month.NOVEMBER, 1, 1, 0);
        ZonedDateTime zd2 = ZonedDateTime.of(ld2, ZoneId.of("US/Eastern"));
        long x = ChronoUnit.HOURS.between(zd1, zd2);
        System.out.println(x);


        System.out.println("java.time.LocalDateTime.of(2015, 10, 1, 10, 10) :  " + java.time.LocalDateTime.of(2015, 10, 1, 10, 10));

        LocalDateTime greatDay = LocalDateTime.parse("2015-01-01T17:13:50");//2
         String greatDayStr = greatDay.format(DateTimeFormatter.ISO_DATE_TIME); //3
           System.out.println("greatDayStr :  "+greatDayStr);

        System.out.println(       LocalDateTime.parse("2015-01-02T17:13"));


        Duration d = Duration.between(LocalDateTime.now(), LocalDateTime.of(2018, Month.AUGUST, 15, 10, 07));
        System.out.println(" LINE 106 :"+ d);

    }
}

