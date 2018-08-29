package Stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by mkoduri on 6/19/2018.
 */
public class StreamsParallelVSSequential {

    public static void main(String[] args) {


        long currentTime=System.currentTimeMillis();

        System.out.println("=================================");
        System.out.println("Using Sequential Stream");
        System.out.println("=================================");
        int[] array= {1,2,3,4,5,6,7,8,9,10};

        IntStream intArrStream= Arrays.stream(array);
        intArrStream.forEach(s-> { System.out.println(s+" "+Thread.currentThread().getName());});
        long endTime=System.currentTimeMillis();
        System.out.println("Time taken to complete:"+(endTime-currentTime)/(1000*60)+" minutes");

        //int[] array= {1,2,3,4,5,6,7,8,9,10};
        System.out.println("=================================");
        System.out.println("Using Parallel Stream");
        System.out.println("=================================");

        IntStream intParallelStream=Arrays.stream(array).parallel();
        intParallelStream.forEach(s-> {  System.out.println(s+" "+Thread.currentThread().getName()); });

        //long endTime=System.currentTimeMillis();
       // System.out.println("Time taken to complete:"+(endTime-currentTime)/(1000*60)+" minutes");


        List<Integer> list = Arrays.asList(10, 11, 30, 30, 25, 68);

        Stream<Integer> ps = list.parallelStream();
        Stream<Integer> ps1 = list.stream().parallel();

        //Stream<Integer> ps2 = Arrays.stream(list.toArray()).parallel();
        //This will not compile because the call to list.toArray() will return an Object[], which when passed to Arrays.stream() method will return you a Stream<Object> object. It cannot be assigned to a Stream<Integer> variable.


    }
}
