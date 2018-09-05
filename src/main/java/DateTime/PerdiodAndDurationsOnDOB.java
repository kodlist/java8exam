package DateTime;

import java.time.*;
import java.time.temporal.ChronoUnit;

/**
 * Created by mkoduri on 7/2/2018.
 *
 * Periods and Durations
 * To define an amount of time with date-based values (years, months, days), use the Period class.
 *
 * we can figure out how manys passed out since you are born.
 *
 *
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
 * Duration class
 *
 * toDays()
 * toHours()
 * toMills()
 * toMinutes()
 * toNanos()
 *
 *
 */
public class PerdiodAndDurationsOnDOB {

    public static void main(String[] args) throws InterruptedException {


        System.out.println("============= Dys between today and time your born =============");
        LocalDate today = LocalDate.now();
        LocalDate birthday = LocalDate.of(1974, Month.SEPTEMBER, 15);
        Period p = Period.between(birthday, today);
        long p2 = ChronoUnit.DAYS.between(birthday, today);
        System.out.printf("You are %d years, %d months, and %d days old (%d days total) %n", p.getYears(), p.getMonths(), p.getDays(), p2);


        System.out.println("============= Time duration from current and after 10 second =============");

        //        The following code calculates, in nanoseconds, the duration between two instants:

        // Current time
        Instant now1 = Instant.now();
        // Wait __appropximately__ 1 second
        Thread.sleep(1000);
        // Current time
        Instant now2 = Instant.now();
        // Calculate real duration
        long ns = Duration.between(now1, now2).toNanos();
        System.out.println("Duration (ns) : " + ns);

        System.out.println("============ Time duration from current and after 1 minute ============= ");

        // Current time
        Instant now3 = Instant.now();
        System.out.println("======= now3 ========="+ now3);
        // Wait __appropximately__ 1 second
        Thread.sleep(10000);
        // Current time
        Instant now4 = Instant.now();
        // Calculate real duration
        long minutes = Duration.between(now3, now4).toMinutes();
        System.out.println("Duration (min) : " + minutes);

        System.out.println("======== period ============ ");
        Period p1 = Period.between(LocalDate.now(), LocalDate.of(2017, Month.AUGUST, 1));
        System.out.println(p1);
        Duration d = Duration.between(  LocalTime .now(), LocalTime.of(12, 00, 00));
       System.out.println("time duration: "+d);
        //Duration d = Duration.between(LocalDate.now(), LocalDate.of(2015, Month.SEPTEMBER, 1)); System.out.println(d);

        Duration d2 = Duration.ofMillis(1100);
        System.out.println("duration of ofMillis : "+d2);
        d = Duration.ofSeconds(61);
        System.out.println("duration 1 minute and 1 secound : "+d);

        Duration d1 = Duration.ofDays(1);
        System.out.println("duration of days:  "+d1);
        System.out.println("========================================");

        LocalDateTime ld = LocalDateTime.of(2015, Month.OCTOBER, 31, 10, 0);
        ZonedDateTime date = ZonedDateTime.of(ld, ZoneId.of("US/Eastern"));
        System.out.println(" ld zone : "+ date);
        date = date.plus(Duration.ofDays(1));
        System.out.println(date);
        date = ZonedDateTime.of(ld, ZoneId.of("US/Eastern"));
        date = date.plus(Period.ofDays(1));
        System.out.println(date);
        System.out.println(" Period.ofDays(1) : "+ Period.ofDays(1));
        System.out.println(" Duration.ofDays(1) : "+ Duration.ofDays(1));


        Duration dx = Duration.ofDays(1);
        System.out.println(dx);
        dx = Duration.ofMinutes(0);
        System.out.println("===== LINE 106 ==== "+dx);
        Period px = Period.ofMonths(0);
        System.out.println(px);

        Duration ds = Duration.ofMillis(1100);
        System.out.println("===== line 111 ==== "+ds);
        ds = Duration.ofSeconds(61);
        System.out.println("===== line 113 ==== "+ds);
    }
}


