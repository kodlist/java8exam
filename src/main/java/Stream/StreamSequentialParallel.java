package Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by mkoduri on 6/19/2018.
 */
public class StreamSequentialParallel {

    public static void main(String[] args) {

        /*============= sequential stream ================== */
        System.out.println("The following snippet of code shows serial processing of the stream pipeline because the stream is sequential:");
        Integer[] intArray1 = {1, 2, 3, 4, 5, 6, 7, 8};
        List<Integer> listOfIntegers1 = new ArrayList<>(Arrays.asList(intArray1));

        System.out.println("Sequential Stream: ");
        listOfIntegers1
                .stream()
                .forEach(e -> System.out.print(e + " "));


        /*============== parallel stream ================== */
        System.out.println("The following snippet of code shows parallel processing of the stream pipeline because the stream is parallel:");

        Integer[] intArray2 = {1, 2, 3, 4, 5, 6, 7, 8};
        List<Integer> listOfIntegers2 = new ArrayList<>(Arrays.asList(intArray2));

        System.out.println("Parallel Stream: ");
        listOfIntegers2
                .stream()
                .parallel()
                .forEach(e -> System.out.print(e + " "));


        long currentTime=System.currentTimeMillis();

        System.out.println("=================================");
        System.out.println("Using Sequential Stream");
        System.out.println("=================================");
        int[] array= {1,2,3,4,5,6,7,8,9,10};

        IntStream intArrStream=Arrays.stream(array);
        intArrStream.forEach(s-> { System.out.println(s+" "+Thread.currentThread().getName());});
        long endTime=System.currentTimeMillis();
        System.out.println("Time taken to complete:"+(endTime-currentTime)/(1000*60)+" minutes");


        System.out.println("=================================");
        System.out.println("Using Parallel Stream");
        System.out.println("=================================");

        IntStream intParallelStream=Arrays.stream(array).parallel();
        intParallelStream.forEach(s-> {  System.out.println(s+" "+Thread.currentThread().getName()); });
    }
}
