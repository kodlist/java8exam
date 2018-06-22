package Stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * Created by mkoduri on 6/18/2018.
 */

class Employee{

    String name; String department;

    public Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return getName() ;
    }
}

public class GroupingByUsingJava8 {

    public static void main(String[] args) {

        Employee e1 = new Employee("Mikalai", "Development");
        Employee e2 = new Employee("Volha", "HR");
        Employee e3 = new Employee("Anastasia", "Management");
        Employee e4 = new Employee("Daria", "Management");
        Employee e5 = new Employee("Ivan", "Management");


        System.out.println("============== JAVA 8 GroupingBy =================");
        Stream<Employee> str = Stream.of(e1, e2, e3, e4, e5); //put our Employee object in MAP using department as Key.
        Map<String, List<Employee>> map = str.collect(Collectors.groupingBy(Employee::getDepartment));

        System.out.println(map.get("Management"));

        map.forEach((key, value) -> {
            System.out.println("Key : " + key + "              Value : " + value);
        });
        System.out.println("size of new map : "+ map.size());

        System.out.println("============== JAVA 8 GroupingBy and Counting =================");
        // Counting Employees by department
        //Stream str is already closed hence we had to initiate stream object again
        str = Stream.of(e1, e2, e3, e4, e5);
        Map<String, Long> map1 = str.collect(  Collectors.groupingBy(Employee::getDepartment, Collectors.counting())    );
        System.out.println(map1.get("Management"));

        System.out.println("============== JAVA 8 with Delimiter =================");
        //Stream str is already closed hence we had to initiate stream object again
        str = Stream.of(e1, e2, e3, e4, e5);
        String names = str.map(Employee::getName).collect(Collectors.joining(", "));
        System.out.println(names );

    }
}
