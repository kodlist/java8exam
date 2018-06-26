package Stream;

import java.util.Arrays;
import java.util.List;

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

        sum = list.stream().reduce(0, Integer::sum);
        System.out.println(sum);

    }
}
