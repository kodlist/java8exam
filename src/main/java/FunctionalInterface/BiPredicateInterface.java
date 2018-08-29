package FunctionalInterface;

import java.util.function.BiPredicate;

/**
 * Created by mkoduri on 7/28/2018.
 *
 *Note that instances of functional interfaces can be created with lambda expressions, method references, or constructor references.
 *
 *
 *
 * BiPredicate test
 BiPredicate and
 BiPredicate negate
 BiPredicate or

 @FunctionalInterface
 public interface BiPredicate<T,U>{

 }
 */

interface  xyx{

    public default void m1()
    {

    }



    @Override
    public int hashCode();

    public int dox();
}
public class BiPredicateInterface implements xyx{


    @Override
    public int dox() {
        return 0;
    }

    public static void main(String[] args) {

        BiPredicate<Integer, Integer> bi = (x, y) -> x > y;
        System.out.println(bi.test(2, 3));

        boolean result = compare( (c1, c2) -> c1/2 == c2 , 2,3);

        //sBiPredicate<Integer, Integer> bi = (x, y) -> x > y;

        BiPredicate<Integer, Integer> eq = (x, y) -> x -2 > y;

        System.out.println(bi.test(2, 3));
        System.out.println(bi.and(eq).test(2, 3));

    }

    public static boolean compare(BiPredicate<Integer, Integer> bi, Integer i1, Integer i2)
    {


        return true;
    }
}
