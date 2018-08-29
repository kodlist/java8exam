package collections;

import java.util.*;
import java.util.stream.IntStream;

/**
 * Created by mkoduri on 6/25/2018.
 */
public class CollectionEnhancement {

    public static void main(String[] args) {



        Set<String> set = new HashSet<>();
        set.add("A");
        set.add("AA");
        set.add("B");
        System.out.println(set);
        set.removeIf(s -> s.startsWith("A"));
        System.out.print(set);

System.out.println("\n----------");

        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("AA");
        list.add("B");
        list.replaceAll(s -> s.toLowerCase());
        System.out.println(list);

        int i = IntStream.range(1, 5).reduce(1, (x, y) -> x * y);
        System.out.println( i);

        List<Integer> ls = Arrays.asList(10, 47, 33, 23);
        int i1 = ls.stream().max(Comparator.comparing( a-> a)).get();

        System.out.println("1st "+ i1);

        int i2 = ls.stream().reduce((a, b)-> a>b ?  a:b  ).get();
        System.out.println("snd "+ i2);
       System.out.println( ls.stream().distinct().anyMatch(x->x==33));
    }
}
