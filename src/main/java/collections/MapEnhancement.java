package collections;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Created by mkoduri on 6/25/2018.
 */
public class MapEnhancement {

    public static void main(String[] args) {



        Map<String, Integer> map = new HashMap<>();
        map.compute("A", (k, v) -> (v == null) ? 0 : v + 1);
        map.compute("A", (k, v) -> (v == null) ? 0 : v + 1);
        map.compute("B", (k, v) -> (v == null) ? 5 : v + 1);
        System.out.println(map);

        System.out.println("=========== computeIfPresent ============");

        Map<String, Integer> map2 = new HashMap<>();

        BiFunction f1 = new BiFunction() {
            @Override
            public Object apply(Object k, Object v) {
                System.out.println("f1: Received " + k + " and " + v);
                Integer i = 0;
                System.out.println("f1: Returning " + i);
                return i;
            }
        };

        map2.put("A", 1);
        Integer i;
        i = map2.get("A");
        System.out.println(i);
        i = map2.computeIfPresent("A", f1);
        System.out.println(i);
        i = map2.get("A");
        System.out.println(i);



        System.out.println("=========== computeIfAbsent ============");


        Map<String, Integer> map3 = new HashMap<>();

        Function<String, Integer> f2 = new Function<String, Integer>() {
            @Override
            public Integer apply(String t) {
                System.out.println("f2: Received " + t);
                Integer i = 0;
                System.out.println("f2: Returning " + i);
                return i;
            }
        };
        Integer i1;
        i1 = map3.get("A");
        System.out.println(i1);
        i1 = map3.computeIfAbsent("A", f2);
        System.out.println(i1);
        i1 = map3.get("A");
        System.out.println(i1);










    }
}
