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
        // Wait __appropximately__ 1 second
        Thread.sleep(10000);
        // Current time
        Instant now4 = Instant.now();
        // Calculate real duration
        long minutes = Duration.between(now3, now4).toMinutes();
        System.out.println("Duration (min) : " + minutes);
    }
}


