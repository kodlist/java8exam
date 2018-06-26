package Files;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by mkoduri on 6/25/2018.
 */
public class FilesFind {

    public static void main(String[] args) throws IOException {

        System.out.println("===================== JAVA 8 =========================");

        Path start = Paths.get("C:\\Users\\mkoduri\\Documents\\parent");
        int maxDepth =3;


       /* public static Stream<Path> find(Path start,
        int maxDepth,
        BiPredicate<Path,BasicFileAttributes> matcher,
        FileVisitOption... options)
                         throws IOException*/


        try (Stream<Path> stream = Files.find(start, maxDepth, (path, basicFileAttributes) -> String.valueOf(path).endsWith(".txt")))
        {
            String joined = stream
                            .sorted()
                            .map(String::valueOf)
                            .collect(Collectors.joining("; "));

            System.out.println("Found: " + joined);
        }


        System.out.println("==============================================");

        // Search in current directory or
        // the one given as program param:
        Path dir;
        if (args.length == 0) {
            dir = Paths.get(".");  // "." meaning current directory
        } else {
            dir = Paths.get(args[0]);
        }

        System.out.printf("First 5 '.md' files in %s: %n", dir.toAbsolutePath());

        try (Stream<Path> paths = Files.find(dir, Integer.MAX_VALUE, (path,attrs) -> attrs.isRegularFile() && path.toString().endsWith(".md")))
        {
            // Consume only the first 5 from the stream:
            paths.limit(5).forEach(System.out::println);
        }


        System.out.println("================== JAVA 7 ============================");


        File dirx = new File("C:\\Users\\mkoduri\\Documents\\parent");

        File[] matches = dirx.listFiles(new FilenameFilter()
        {
            public boolean accept(File dir, String name)
            {
                System.out.println(dir.getAbsolutePath() + " == " +"  == "+name);
                return name.endsWith(".txt");
            }
        });
        System.out.println("==============================================");
        for (File f: matches ) {
            System.out.println(f);

        }
        System.out.println("======================================================");

        System.out.println("===================== JAVA 8 =========================");
    }
}
