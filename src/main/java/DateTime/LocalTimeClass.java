package DateTime;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

/**
 * Created by mkoduri on 9/5/2018.
 */
public class LocalTimeClass {

    public static void main(String[] args) {


        LocalTime now = LocalTime.now();
        System.out.println("======line 16 =======");
        System.out.println( now);

        LocalTime gameStart = LocalTime.of( 10, 15);

        long timeConsumed =0;
        long timeToStart = 0;

        if( now.isAfter(  gameStart ))
        {
            System.out.println("===== line 26 =====");
            timeConsumed  = gameStart.until(  now , ChronoUnit.HOURS);
        }else{
            System.out.println("===== line 29 =====");
            timeToStart = now.until(gameStart  , ChronoUnit.HOURS);
        }
        System.out.println("===== line 32 ======");
        System.out.println(  timeToStart + " "+ timeConsumed);


    }
}
