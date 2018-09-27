package Stream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by mkoduri on 8/1/2018.
 */
class Book{
    String title;
    int price;

    public Book(String title, int price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
public class IntStreamClass {

    public static void main(String[] args) {

        // if you just want to convert an IntStream to a Stream<Integer>, there's a dedicated function for this job called boxed.

        IntStream.rangeClosed(10, 15)
                                                .boxed()
                                                .filter(x->x>12)
                                                .parallel()
                                                .findAny().ifPresent( s -> System.out.println(s));



        //map takes Function  - Intermediate operation
        //peek takes Consumer  - Intermediate operation
        //filter takes Predicate  - Intermediate operation


        //forEach takes Consumer - Terminal operation

        //Collectors.groupingBy - takes Function ex: items.stream().collect(  Collectors.groupingBy(ItemX::getCategory));
                                                // ex:  items.stream().collect( Collectors.averagingDouble(  priceF));

        Optional v1 = IntStream.rangeClosed(10, 15).boxed().filter(x->x>12).parallel().findAny();
        Optional v2 = IntStream.rangeClosed(10, 15).boxed().filter(x->x>12).sequential().findAny();

        System.out.println("====== line 67 ===== "+v1.get() +"  :  "+ v2);
        Optional o1 = IntStream.rangeClosed(10, 15).boxed().filter(x->x>12).sequential().findFirst();
        Integer o2 = IntStream.rangeClosed(10, 15).boxed().filter(x->x>12).sequential().findFirst().get();
        int o3 =  IntStream.rangeClosed(10, 15).boxed().filter(x->x>12).sequential().findFirst().get().intValue();

        System.out.println("========== line 57 ====");
        System.out.println( o1 +" :  "+ o2 + "  :  "+ o3);



//http://www.deadcoderising.com/2015-05-19-java-8-replace-traditional-for-loops-with-intstreams/

        List<Book> books = Arrays.asList( new Book("Freedom at Midnight", 5),
                                            new Book("Gone with the wind", 5),
                                            new Book("Midnight Cowboy", 15) );

        System.out.println("=========1===========");
        books.stream().filter(b->b.getTitle().startsWith("F")).forEach(s -> System.out.println(s.getTitle()));
        System.out.println(books);
        System.out.println("==========2==========");
        books.stream().filter(b->b.getTitle().startsWith("F")).forEach(b->b.setPrice(10));
        System.out.println("===========3=========");

        books.stream().forEach(b->System.out.println(b.getTitle()+":"+b.getPrice()));
        System.out.println("====================");
//http://www.deadcoderising.com/2015-05-19-java-8-replace-traditional-for-loops-with-intstreams/

        List<String> strList = Arrays.asList("a", "aa", "aaa");

        System.out.println("=======line 96 =======");
        Function<String, Integer> f = x->x.length();
        strList.stream().map(f).forEach(s-> System.out.println("  len "+s));
        System.out.println("======line 99 =======");
        strList.stream().forEach( s-> System.out.println("  len "+s) );
        System.out.println("=====line101 =========");
        int sizeoflist = strList.size();

        // java 7 vs java 8 (see above line 87)
        for ( String s:strList ) {
           // System.out.println( s  + " "+s.length());
                if(s.length()>2)
                {
                    System.out.println(s);
                }
        }

        System.out.println("======line 106 ========");
        System.out.println("=========line 99 ===============");

        int[] values = new int[]{ 3,4,2,1 };

        IntStream ar= Arrays.stream(values);


        IntStream pis = ar.parallel();
        OptionalDouble av = pis.average();
        av.ifPresent(System.out::println);

        String [] stre = new String[]{"d","ff"};
        Stream<String> s= Arrays.stream(stre);


        OptionalInt is = IntStream.range(1, 4).reduce((a, b)->a+b);
        System.out.println( is.getAsInt() + "  ");

        IntStream is2 = IntStream.rangeClosed(1, 4);
        int sum = is2.reduce(0, (a, b)->a+b);
        System.out.println(sum);



        List<Book> books1 = Arrays.asList( new Book("Freedom at Midnight", 5),
                new Book("Gone with the wind", 5),
                new Book("Midnight Cowboy", 15) );

       // Reader r = (x) -> { x.getTitle();} ;

        Reader r = b->{     System.out.println("Reading book "+b.getTitle());};
        books1.forEach( x-> r.read(x)  );




    }
    interface Reader{

        default void read(Book b){

        }
        void unread(Book b);
    }
}
