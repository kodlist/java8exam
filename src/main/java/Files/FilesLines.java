package Files;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by mkoduri on 6/26/2018.
 *
 * The lines() method reads all lines from a file as a Stream.
 *
 * The readAllLines(...) method reads all lines from a file into a List of Strings.
 *
 * java.nio.file.Files class has two overloaded lines method.
 * One takes just a Path object and the other takes a Path object as well as a Charset object.
 * Both the versions returns a Stream<String> object that contains the lines in the file.
 * The stream is lazily populated, which means, it doesn't read the whole file upfront.
 * It reads the file as you consume the elements of the stream. This helps if you have a large file and less memory.
 *
 */
public class FilesLines {

    public static void main(String[] args) throws IOException {

        System.out.println("===================== JAVA 8 Files.lines =========================");
        Path f = Paths.get("C:\\Users\\mkoduri\\Documents\\parent\\doc1.txt");
        try (Stream<String> stream = Files.lines(f)) {
            stream.forEach(System.out::println);
        }

        //The call to readAllLines should be changed to lines to prevent failure while processing large files.

        /*
            java.nio.file.Files class has both the methods - readAllLines as well as lines.

            1. readAllLines is a Java 7 way to read the contents of a file. This methods pulls the whole file in memory and returns a List<String> object.
            Since it reads the whole file upfront, it may fail if the file is too large and cannot fit into available memory.

            2. lines is a Java 8 way to read the contents of a file. It is different from readAllLines in two ways:    
            a) It returns a Stream<String> object    b) The stream is lazily populated, which means, it doesn't read the whole file upfront.
            It reads the file as you consume the elements of the stream. This helps if you have a large file.


         */

        System.out.println("===================== JAVA 7 Files.readAllLines =========================");
        List<String> list = Files.readAllLines(f);
        list.stream().forEach(System.out::println);

        System.out.println("===================== JAVA 8 Files.walk =========================");

        Path start = Paths.get("C:\\Users\\mkoduri\\Documents\\parent");
        int maxDepth = 5;
        try (Stream<Path> stream = Files.walk(start, maxDepth)) {
            stream.forEach(System.out::println);
        }
        System.out.println("===================== JAVA 8 Files.walk =========================");
        try (Stream<Path> stream = Files.walk(start)) {
            stream.forEach(System.out::println);
        }

        Stream<String> lines = Files.lines(Paths.get("/foo/bar/baz.a"), Charset.defaultCharset());

        System.out.println(Charset.defaultCharset());

        /*

                There are two overloaded walk methods in java.nio.file.Files class:

                public static Stream<Path> walk(Path start, int maxDepth, FileVisitOption... options) throws IOException
                and
                public static Stream<Path> walk(Path start, FileVisitOption... options) throws IOException

         */

    }
}
