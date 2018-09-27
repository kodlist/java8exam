package Stream;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;

/**
 * Created by mkoduri on 6/25/2018.
 *
 * reduce(T identity, BinaryOperator<T> accumulator) method of the Stream interface performs a reduction operation on the stream to reduce the stream to a single value.
 */
public class ReductionAndDecomposition {

    public static void main(String[] args) {


        Integer[]arr = {1,2,3};
        List<Integer> list = Arrays.asList(arr);
        Integer sum = list.stream().reduce( 0, (n1, n2) -> n1+n2);
        System.out.println(sum);

        sum = list.stream().reduce(2, Integer::sum);
        System.out.println(sum);

        sum = list.stream().reduce( 1,(n1, n2) -> n1+n2);
        System.out.println(sum);
        System.out.println("========== lin 26 =======");
        sum = list.stream().reduce(2, Integer::max);
        System.out.println(sum);

        System.out.println("========== lin 30 =======");
        sum = list.stream().reduce(2, Integer::min);
        System.out.println(sum);


        System.out.println("=========== line 35 =========");

        IntStream i = IntStream.of(2, 3, 3);
        int v = i.reduce(0,(n1,n2)->n1+n2);

        System.out.println(v);

        System.out.println("========== line 43 =========");

        IntStream i2 = IntStream.of( 3, 3);
        OptionalInt v2 = i2.reduce(Integer::sum);
        if(v2.isPresent()){
            System.out.println(v2.getAsInt());
        }else{
            System.out.println(v2);
        }




    }
}
