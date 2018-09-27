package Stream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by mkoduri on 9/27/2018.
 *
 *
 * Collectors.toMap
 * Collectors.joining
 * Collectors.partitioningBy
 * Collectors.mapping
 * Collectors.summarizingInt
 * Collectors.toList()
 * Collectors.groupingBy
 *
 */

class StudentX {

    public static enum Grade {        A, B, C, D, F    }

    private String name;
    private Grade grade;

    public StudentX(String name, Grade grade) {
        this.name = name;
        this.grade = grade;
    }

    @Override
    public String toString()    {        return name+ "  :  "+ grade ;    }

    public String getName() {        return name;    }

    public void setName(String name) {        this.name = name;    }

    public Grade getGrade() {        return grade;    }

    public void setGrade(Grade grade) {        this.grade = grade;    }
}


public class CollectorsClass {

    public static void main(String[] args) {

        List<StudentX> ls = Arrays.asList(new StudentX("S1", StudentX.Grade.A), new StudentX("S2", StudentX.Grade.A), new StudentX("S3", StudentX.Grade.C));


        Map<StudentX.Grade, List<StudentX>> grouping = ls.stream().collect(Collectors.groupingBy(g -> g.getGrade()));
        // the return type of groupingBy is :  Map<StudentX.Grade, List<StudentX>>

        System.out.println("======line 45 ======");
        System.out.println(grouping);
        System.out.println("========line 47 =======");

        System.out.println("======== 49 =======");
        //the result of "grouping" and "grouping1" is totally different. you have to understand the output of diff toMap in Collectors.
        Map<StudentX.Grade, String> grouping1 = ls.stream().collect(   Collectors.toMap(StudentX::getGrade, StudentX::getName,(oldValue, newValue) -> oldValue));

        System.out.println( grouping1);
        Map<StudentX.Grade, String> grouping2 = ls.stream().collect(   Collectors.toMap(StudentX::getGrade, StudentX::getName,(oldValue, newValue) -> oldValue+newValue ));


        System.out.println("========= 67 =======");
        System.out.println(grouping2);

        //the result of "grouping" and "grouping1" and "grouping2" is totally different. you have to understand the output of diff toMap in Collectors.
        Map<StudentX.Grade, StudentX> grouping3 = ls.stream().collect(Collectors.toMap(p -> p.getGrade(), p -> p, (oldValue, newValue) -> newValue    ));
        System.out.println("========= 72 =======");
        System.out.println(grouping3);


        Map<Boolean,  List<StudentX>> l = ls.stream().collect(Collectors.partitioningBy(s -> s.getGrade() == StudentX.Grade.A));
        // the return type of partitioningBy is :  Map<Boolean, List<StudentX>>

        System.out.println("============line 66============");
        List<Integer> names = Arrays.asList(1, 2, 3);

        IntSummaryStatistics sts = names.stream().collect(Collectors.mapping(x->x, Collectors.summarizingInt(x->x)));
        System.out.println(  sts.getSum());

        System.out.println(names.stream().collect(Collectors.mapping(x->x, Collectors.summarizingInt(x->x))).getSum());
        System.out.println(names.stream().collect(Collectors.summarizingInt(x->x)).getSum());
        System.out.println("==========line 71 ===========");


        Student s1 = new Student("Karen", 18);
        Student s2 = new Student("Ryne",22);
        Student s3 = new Student("Ftiz",19);
        Student s4 = new Student("Emliy",20);
        Student s5 = new Student("Cyrus",21);
        List<Student> list = Arrays.asList(s1,s2,s3,s4,s5);

        System.out.println("----Partition of Student on the basis of age >20 ----");

        Map<Boolean, List<Student> > mapx = list.stream().collect(Collectors.partitioningBy(s->s.getAge() > 20 )) ;

        //Map<Boolean, List<Stream.Student> >  mapx=  list.stream().collect(Collectors.partitioningBy(s -> s.getAge() > 20)  );

                list.stream()
                .collect(Collectors.partitioningBy(s -> s.getAge() > 20))
                .forEach((n,g) ->  System.out.println("n : "+n + "  "+ ((List<Student>)g).stream().map(s->s.getName()).collect(Collectors.joining(",")))  );

        System.out.println("==========line 84=========");

       // ls.stream().map( s->s.getGrade()).collect(Collectors.joining(",")  );

        Employee e1 = new Employee("Mikalai", "Development");
        Employee e2 = new Employee("Volha", "HR");
        Employee e3 = new Employee("Anastasia", "Management");
        Employee e4 = new Employee("Daria", "Management");
        Employee e5 = new Employee("Ivan", "Management");
        Stream<Employee> str = Stream.of(e1, e2, e3, e4, e5);
        String names1 = str.map(Employee::getName).collect(Collectors.joining(", "));
        System.out.println(names1 );
       // with map you can not get the predicate. because map reutrns stream of getName.



        List<String> itemsA =
                Arrays.asList("apple", "apple", "banana",
                        "apple", "orange", "banana", "papaya");
        System.out.println("==========line 107=========");

        Map<String, Long> map1 = itemsA.stream().collect(Collectors.groupingBy(Function.identity() ,  Collectors.counting()));
        System.out.println(map1);


        Map<Integer, String> map = new HashMap<>();
        map.put(23, "Mahesh");
        map.put(10, "Suresh");
        map.put(26, "Dinesh");
        map.put(11, "Kamlesh");
        System.out.println("--Convert Map Values to List--");

        List<String> sortedValueList = map.values().stream().sorted().collect(Collectors.toList());
        sortedValueList.stream().forEach(e-> System.out.println(e));
    }
}
