package Files;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;

/**
 * Created by mkoduri on 6/26/2018.
 *
 *
 * BasicFileAttributes
 *
 * Java printf( )
 *
 * % [flags] [width] [.precision] conversion-character ( square brackets denote optional parameters )
 */
public class FileAttributesOfJava7
{

    public static void main(String[] args) throws IOException {

        //BasicFileAttributes


        Path file = Paths.get("C:\\Users\\mkoduri\\Documents\\parent","doc1.txt");


        BasicFileAttributes basicAttr = Files.readAttributes(file, BasicFileAttributes.class);
        FileTime creationTime = basicAttr.creationTime();
        System.out.println(creationTime);
        FileTime lastAccessTime = basicAttr.lastAccessTime();
        System.out.println(lastAccessTime);
        FileTime lastModifiedTime = basicAttr.lastModifiedTime();
        System.out.println(lastModifiedTime);


    }
}
