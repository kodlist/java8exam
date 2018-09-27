package CollectionsAndStreamWithLambdas;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;

/**
 * Created by mkoduri on 9/26/2018.
 */
class Book{

    private int id;
    private String title;
    private String genre;
    private String author;

    public Book(String title, String genre, String author) {
        this.title = title;
        this.genre = genre;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public String getAuthor() {
        return author;
    }

    public static class BookFilter{

        public static boolean isFiction(Book b){
            return b.getGenre().equalsIgnoreCase("fiction");
        }

    }
}

public class BookClassWithStaticClass {

    public static void main(String[] args) {

        List<Book> books = Arrays.asList(new Book("30 Days", "fiction", "K Larsen") ,
                new Book("Fast Food Nation", "non-fiction", "Eric Schlosser"),
                new Book("Wired", "fiction", "D Richards"));

        books.stream()
                .filter((Book b)-> Book.BookFilter.isFiction(b))
                .forEach( (Book b) -> System.out.println(b.getTitle() + " , "));

        books.stream()
                .filter(Book.BookFilter::isFiction)
                .forEach( (Book b) -> System.out.println(b.getTitle() + " , "));

        System.out.println();



    }


}
