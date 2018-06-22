package Stream;

import java.util.Arrays;
import java.util.stream.IntStream;

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
    }
}
