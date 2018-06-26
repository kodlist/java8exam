package Files;

import java.io.IOException;
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
 */
public class FilesLines {

    public static void main(String[] args) throws IOException {

        System.out.println("===================== JAVA 8 Files.lines =========================");
        Path f = Paths.get("C:\\Users\\mkoduri\\Documents\\parent\\doc1.txt");
        try (Stream<String> stream = Files.lines(f)) {
            stream.forEach(System.out::println);
        }

        System.out.println("===================== JAVA 8 Files.readAllLines =========================");
        List<String> list = Files.readAllLines(f);
        list.stream().forEach(System.out::println);

        System.out.println("===================== JAVA 8 Files.walk =========================");

        Path start = Paths.get("C:\\Users\\mkoduri\\Documents\\parent");
        int maxDepth = 5;
        try (Stream<Path> stream = Files.walk(start, maxDepth)) {
            stream.forEach(System.out::println);

        }

    }
}
