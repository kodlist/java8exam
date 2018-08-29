package Stream;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntConsumer;
import java.util.stream.Collectors;

/**
 * Created by mkoduri on 8/24/2018.
 */


class Person {

    public enum Sex {
        MALE, FEMALE
    }

    String name;
    LocalDate birthday;
    Sex gender;
    String emailAddress;
    int age;


    Person(String name, Sex s, int age)
    {
        this.name = name;
        this.gender = s;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
       return name;
    }
    public Sex getGender()
    {
        return gender;
    }
}
class Averager implements IntConsumer
{
    private int total = 0;
    private int count = 0;

    public double average() {
        return count > 0 ? ((double) total)/count : 0;
    }

    @Override
    public void accept(int i) {
        total += i;
        count++;
        System.out.println( "total : "+ total + " : "+ "count : "+ " : "+ count);
    }

    public void combine(Averager other) {
        System.out.println(  "Avergaer object :  "+ other );
        total += other.total;
        count += other.count;

        System.out.println( " total : "+ total);
    }

}


public class StreamCollectMethod {

    public static void main(String[] args) {


        //map takes Function  - Intermediate operation
        //peek takes Consumer  - Intermediate operation
        //filter takes Predicate  - Intermediate operation

        //forEach takes Consumer - Terminal operation

        //Collectors.groupingBy - takes Function ex: items.stream().collect(  Collectors.groupingBy(ItemX::getCategory));
                                                 // ex:  items.stream().collect( Collectors.averagingDouble(  priceF));

        List<Person> roster = Arrays.asList(new Person("georgia", Person.Sex.MALE, 23) ,
                new Person("luke", Person.Sex.MALE , 34),
                new Person("christe", Person.Sex.FEMALE, 40) );


        Averager averageCollect = roster.stream()
                                                .filter(p -> p.getGender() == Person.Sex.MALE)
                                                .map(Person::getAge)
                                                .collect(Averager::new,
                                                        Averager::accept,
                                                        Averager::combine);

        System.out.println("Average age of male members: " +                averageCollect.average());


        System.out.println("=========== line 89 ===========");
        List<Integer> names = Arrays.asList(1, 2, 3);

        System.out.println(names.stream().collect(Collectors.mapping(x->x, Collectors.summarizingInt(x->x))).getSum());
        System.out.println(names.stream().collect(Collectors.summarizingInt(x->x)).getSum());

        List<Book> books = Arrays.asList(         new Stream.Book("Freedom at Midnight", 5),
                new Book("Gone with the wind", 5),
                new Book("Midnight Cowboy", 15) );
        books.stream()
                .filter(b->b.getTitle().startsWith("F")).forEach(b->b.setPrice(10)  );


        Double d1 = new Double(12.2);

        d1 = d1+2.2;
        System.out.println(  "d1 :  "+ (d1.doubleValue()+12.2));

        List<Double> dList = Arrays.asList(10.0, 12.0);
        dList.stream().forEach(x->{ x = x+10; });
        dList.stream().forEach(d->System.out.println(d));



    }
}
