package collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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



        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("AA");
        list.add("B");
        list.replaceAll(s -> s.toLowerCase());
        System.out.println(list);



    }
}
