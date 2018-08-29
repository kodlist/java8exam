package DateTime;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

/**
 * Created by mkoduri on 8/15/2018.
 *
 * public long until(Temporal endExclusive, TemporalUnit unit) Calculates the amount of time until another time in terms of the specified unit.
 * This calculates the amount of time between two LocalTime objects in terms of a single TemporalUnit. The start and end points are this and the specified time.
 * The result will be negative if the end is before the start. The Temporal passed to this method is converted to a LocalTime using LocalTime.from(TemporalAccessor).
 * For example, the amount in hours between two times can be calculated using startTime.until(endTime, HOURS).
 * The calculation returns a whole number, representing the number of complete units between the two times.
 * For example, the amount in hours between 11:30 and 13:29 will only be one hour as it is one minute short of two hours.
 * There are two equivalent ways of using this method. The first is to invoke this method. The second is to use TemporalUnit.between(Temporal, Temporal):    
 * // these two lines are equivalent    amount = start.until(end, ChronoUnit.MINUTES);    amount = ChronoUnit.MINUTES.between(start, end);
 *
 */
public class TemporalClass {

    public static void main(String[] args) {

        long amount1, amount2;
        LocalTime now = LocalTime.now();
        LocalTime gameStart = LocalTime.of(10, 15);
        LocalTime gameEnd = LocalTime.of(11, 15);
        // these two lines are equivalent   
        amount1 = gameStart.until(gameEnd, ChronoUnit.MINUTES);
        amount2 = ChronoUnit.MINUTES.between(gameStart, gameEnd);
        System.out.println(" amount of time btw start and end : "+ amount1 );
        System.out.println(" amount of time btw start and end : "+ amount2 );
    }
}
