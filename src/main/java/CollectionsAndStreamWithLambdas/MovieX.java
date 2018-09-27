package CollectionsAndStreamWithLambdas;

import java.util.Arrays;
import java.util.List;

/**
 * Created by mkoduri on 9/18/2018.
 */
public class MovieX {

    static enum Genre  {DRAMA, THRILLER, HORROR, ACTION };
    private Genre genre;     private String name;     private char rating = 'R';

    public MovieX( String name, Genre genre,char rating) {
        this.genre = genre;
        this.name = name;
        this.rating = rating;
    }

    public Genre getGenre() {
        return genre;
    }

    public String getName() {
        return name;
    }

    public char getRating() {
        return rating;
    }

    public static void main(String[] args) {

        List<MovieX> movies =
                Arrays.asList(  new MovieX("Titanic", MovieX.Genre.DRAMA, 'U'),
                        new MovieX("Psycho", MovieX.Genre.THRILLER, 'U'),
                        new MovieX("Oldboy", MovieX.Genre.THRILLER, 'R'),
                        new MovieX("Shining", MovieX.Genre.HORROR, 'U')    );

        movies.stream()
                .filter(mov->mov.getRating()=='R')
                .peek(x->System.out.println(x.getName()))
                .map(mov->mov.getGenre() )
                .forEach(a-> System.out.println(a));

        System.out.println("========line 43 ===");
        movies.stream()
                .peek(x->System.out.println(" 1 "+x.getName()))
                .filter(mov->mov.getRating()=='R')
                .map(mov->mov.getGenre() )
                .forEach(a-> System.out.println(" 2 "+a));

    }
}
