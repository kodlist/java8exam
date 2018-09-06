package DateTime;

import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 * Created by mkoduri on 9/6/2018.
 */
public class ZonedDateTimeClass {

    public static void main(String[] args) {


        ZonedDateTime zd1 = ZonedDateTime.now();
        System.out.println("======== zd1 ======= : "+ zd1);


        ZonedDateTime zd2 = ZonedDateTime.now(  ZoneId.of("Asia/Tokyo"));
        System.out.println("======== zd2 ======= : "+ zd2);

        Clock clock = Clock.system(ZoneId.of("Asia/Tokyo"));
        ZonedDateTime zd3 = ZonedDateTime.now(clock);
        System.out.println("======== zd3 ======= : "+zd3);

        DateTimeFormatter format = DateTimeFormatter.ofPattern("HHmm, dd MMM yyyy");
        System.out.println("===== format zd3 ======= : "+ zd3.format(format) );


        Clock clock1LosAngeles = Clock.system(ZoneId.of("America/Los_Angeles"));
        ZonedDateTime zd4LosAngeles = ZonedDateTime.now(clock1LosAngeles);
        System.out.println("======== zd4   ======= : "+zd4LosAngeles);
        System.out.println("======== format los angeles : "+ zd4LosAngeles.format(format));

        LocalTime localTimeLosAngeles = zd4LosAngeles.toLocalTime();
        System.out.println("======= localTimeLosAngeles ====== :"+localTimeLosAngeles);

        LocalTime localTimeaAsiaCalcutta = zd1.toLocalTime();
        System.out.println("======= localTimeaAsiaCalcutta =======: "+ localTimeaAsiaCalcutta);

        Duration d = Duration.between(localTimeLosAngeles , localTimeaAsiaCalcutta);
        System.out.println("time duration: losangeles and calcutta : "+d);


        LocalDateTime ld = LocalDateTime.now(clock1LosAngeles);
        System.out.println("id localdatetime ======== "+ ld.format(format));
        LocalDateTime ld1 = LocalDateTime.now(ZoneId.of("America/Los_Angeles"));
        System.out.println("ld1 localdatetime ======= "+ ld1.format(format));

        LocalDateTime ld2 = LocalDateTime.now(ZoneId.of("Europe/Berlin"));
        System.out.println("ld2 localdatetime ======= "+ ld2.format(format));

    }
}
