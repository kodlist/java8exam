package LambdaExp;

import java.util.function.BiConsumer;

/**
 * Created by mkoduri on 9/26/2018.
 */


public class BiConsumerX {

    public static void main(String[] args) {

        BiConsumer<String, String> biConsumer = (x, y) -> {
            System.out.println(x);
            System.out.println(y);
        };

        BiConsumer<String, String> biConsumer1 = (x, y) -> {
            System.out.println(" x");
            System.out.println("y");
        };

        biConsumer.andThen(biConsumer1).accept("java2s.com", " tutorial");

        //BiConsumer andThen returns a composed BiConsumer that performs, in sequence, this operation followed by the after operation.
    }
}
