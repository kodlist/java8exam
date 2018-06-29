package FlatMapInStreams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by mkoduri on 6/29/2018.
 *
 * * =================================*
 * * Two methods of Stream *
 * flatMapToInt()
 * flatMap()
 * * =================================*
 * Stream can hold different data types, for examples:
 * Stream<String[]>
 * Stream<Set<String>>
 * Stream<List<String>>
 * Stream<List<Object>>
 *
 *
 * But, the Stream operations (filter, sum, distinct…) and collectors do not support it, so, we need flatMap() to do the following conversion :
 *
 * Stream<String[]>		-> flatMap ->	Stream<String>
 * Stream<Set<String>>	-> flatMap ->	Stream<String>
 * Stream<List<String>>	-> flatMap ->	Stream<String>
 * Stream<List<Object>>	-> flatMap ->	Stream<Object>
 *
 * { {1,2}, {3,4}, {5,6} } -> flatMap -> {1,2,3,4,5,6}
 * { {'a','b'}, {'c','d'}, {'e','f'} } -> flatMap -> {'a','b','c','d','e','f'}
 *
 *
 *
 */
public class FlatmapExamples {

    public static void main(String[] args) {

        System.out.println("======== The below code doesnt output any result. ====================");

        String[][] data = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}};

        //Stream<String[]>
        Stream<String[]> temp = Arrays.stream(data);

        //filter a stream of string[], and return a string[]?
        Stream<String[]> stream = temp.filter(x -> "a".equals(x.toString()));

        stream.forEach(System.out::println);


        System.out.println("======================================================================");



        System.out.println("======== The below code will use flatmap and give output on two dimensional array with filter applied on it. ====================");

        Stream<String[]> temp1 = Arrays.stream(data);
        Stream<String> stringStream = temp1.flatMap(x -> Arrays.stream(x));
        Stream<String> streamX = stringStream.filter(x -> "a".equals(x.toString()));
        streamX.forEach(System.out::println);
        System.out.println("==================================================================================================================================");


        System.out.println("======== The below code list of objects, each object has a list of books, we use flatmap and get all books.");
        // Stream + Set + flatMap

        Student obj1 = new Student();
        obj1.setName("mehar");
        obj1.addBook("Sydney sheldon");
        obj1.addBook("Three musketers");
        obj1.addBook("Effective Java (2nd Edition)");

        Student obj2 = new Student();
        obj2.setName("John");
        obj2.addBook("Three musketers");
        obj2.addBook("Effective Java (2nd Edition)");

        List<Student> list = new ArrayList<>();
        list.add(obj1);
        list.add(obj2);

        List<String> collect =
                        list.stream()
                        .map(x -> x.getBook())           //Stream<Set<String>>
                        .flatMap(x -> x.stream())       //Stream<String>
                        .distinct()
                        .collect(Collectors.toList());

        collect.forEach(x -> System.out.println(x));

        System.out.println("=============================================");
        System.out.println("============== flatMapToInt =================");

        int[] intArray = {1, 2, 3, 4, 5, 6};

        //1. Stream<int[]>
        Stream<int[]> streamArray = Stream.of(intArray);

        //2. Stream<int[]> -> flatMap -> IntStream
        IntStream intStream = streamArray.flatMapToInt(x -> Arrays.stream(x));

        intStream.forEach(x -> System.out.println(x));
        System.out.println("=============================================");

    }




}

class Student{

    private String name;

    public Set<String> getBook() {
        return book;
    }

    private Set<String> book;

    public void setName(String name) {
        this.name = name;
    }

    public void addBook(String book) {
        if (this.book == null) {
            this.book = new HashSet<>();
        }
        this.book.add(book);
    }
}
