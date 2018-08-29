package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by mkoduri on 6/16/2018.
 */

class Employee{

    int id;
    String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

public class SortingCollection {

    public static void main(String[] args) {

        System.out.println("============== BEFORE JAVA 8 =================");
        List<Employee> le = Arrays.asList(

                new Employee(101, "john"),
                new Employee(102, "canon"),
                new Employee(103, "Andy")
        );

        //before java 8
        List<String> result = new ArrayList<>();
        for(Employee e : le)  {
            result.add(e.getName());
        }

        for (String s : result  ) {
            System.out.println(s);
        }
        System.out.println("==============================================");

        //from java 8
        System.out.println("=============== FROM JAVA 8 ==================");

        List<String> result1 = le.stream().map(x -> x.getName()).collect(Collectors.toList());
        result1.stream().forEach(System.out::println);
        System.out.println("==============================================");

        System.out.println("================= Using stream with comparator in java 8 (first way)  =============================");
        //sorting in java 8
        le.stream().sorted(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2)
            {
                return o1.getName().compareTo(o2.getName());
            } }).map(x -> x.getName()).collect(Collectors.toList()).forEach(System.out::println);

        System.out.println("================= Using stream with comparator in java 8 (second way) =============================");
        le.stream().sorted((Employee e1, Employee e2) -> e2.getName().compareTo(e1.getName())).map(x -> x.getName()).collect(Collectors.toList()).forEach(System.out::println);

        System.out.println("================= Using comparator on sort method in java 8 (third way) =============================");
        le.sort( (e1, e2) -> e1.getName().compareTo(e2.getName()))  ;
        le.forEach((e) ->  System.out.println(e.getName()));

    }
}
