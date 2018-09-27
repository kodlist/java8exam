package BuiltInLambdaTypes;

import java.time.Month;
import java.util.function.Supplier;

/**
 * Created by mkoduri on 9/22/2018.
 */

class Book{
    private String title;
    private Double price;

    public Book(String title, Double price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public Double getPrice() {
        return price;
    }
}
public class DiffWaysOfLambdaTypes {

    public static void main(String[] args) {

        Book b1 = new Book("Java in 24 hrs", 30.0); Book b2 = new Book("Thinking in Java", null);

        Supplier s1 = b1::getPrice ;

        System.out.println( "====== line 34 ===== "+ b1.getTitle()  +"  "+ s1.get());

        Supplier s2 = b2::getPrice ;

        System.out.println( "====== line 38 ===== "+ b2.getTitle() + "  "+ s2.get());

        System.out.println(  java.time.LocalDateTime.of(2015, Month.JANUARY, 1, 10, 10));
    }

}
