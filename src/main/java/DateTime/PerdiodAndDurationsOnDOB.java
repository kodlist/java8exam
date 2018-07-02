package DateTime;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;

/**
 * Created by mkoduri on 7/2/2018.
 *
 * Periods and Durations
 * To define an amount of time with date-based values (years, months, days), use the Period class.
 *
 * we can figure out how manys passed out since you are born.
 *
 */
public class PerdiodAndDurationsOnDOB {

    public static void main(String[] args) {


        LocalDate today = LocalDate.now();
        LocalDate birthday = LocalDate.of(1974, Month.SEPTEMBER, 15);
        Period p = Period.between(birthday, today);
        long p2 = ChronoUnit.DAYS.between(birthday, today);
        System.out.printf("You are %d years, %d months, and %d days old (%d days total)", p.getYears(), p.getMonths(), p.getDays(), p2);

    }
}


