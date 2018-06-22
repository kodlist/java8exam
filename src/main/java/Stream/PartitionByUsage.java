package Stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by mkoduri on 6/18/2018.
 */

class Student{
    String name;
    int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

public class PartitionByUsage {

    public static void main(String[] args) {

        Student s1 = new Student("Karen", 18);
        Student s2 = new Student("Ryne",22);
        Student s3 = new Student("Ftiz",19);
        Student s4 = new Student("Emliy",20);
        Student s5 = new Student("Cyrus",21);
        List<Student> list = Arrays.asList(s1,s2,s3,s4,s5);

        System.out.println("----Partition of Student on the basis of age >20 ----");
        list.stream()
                .collect(Collectors.partitioningBy(s -> s.getAge() > 20))
                .forEach((n,g) ->  System.out.println("n : "+n + "  "+ ((List<Student>)g).stream().map(s->s.getName()).collect(Collectors.joining(",")))  );


    }
}
