package Stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by mkoduri on 8/28/2018.
 */
public class StreamAndFlatMap {

    public static void main(String[] args) {



        String sentence1 = "Carpe diem. Seize the day, boys. Make your lives extraordinary.";
        String sentence2 = "Frankly, my dear, I don't give a damn!";
        String sentence3 = "Do I look like I give a damn?";
        List<String> sentences = Arrays.asList(sentence1, sentence2, sentence3);


        Stream<String> strm = sentences.
                                        stream().
                                            flatMap(  str->Stream.of(str.split("[ ,.!?\r\n]")) ).
                                                    filter(s->s.length()>0).
                                                           distinct();


        strm.forEach(  c -> System.out.println(c));

        System.out.println("=======line 29 ====");

        String s1 = "ko hug kin";

        String[] s2 = s1.split("[\r]");

        System.out.println(  s2.length  +" : "+ s2[0]);
        System.out.println("==========line 34 =====");

        String[] shapes = "Circle,Square,Rectangle,Hexagon".split(",", 3);
        for ( String s: shapes             ) {
            System.out.println( s);

        }
        System.out.println("======== line 41 =========");
        String[] shapes1 = "Circle,Square,Rectangle,Hexagon".split(",", 10);

        for ( String s: shapes1             ) {
            System.out.println( s);

        }


        System.out.println("=======line 50 ========");
        String[] items = "abc123def456ghi789".split("\\d+");
        for ( String s: items             ) {
            System.out.println( s);

        }


        String[] items1 = "123abc456def789".split("[a-zA-Z].");
        System.out.println("========line 59 =======");
        for ( String  s: items1             ) {
            System.out.println( s);

        }

    }
}
