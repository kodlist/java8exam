package MergeMethodOfMap;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mkoduri on 6/29/2018.
 */
public class MergeExample {

    public static void main(String[] args) {

        Map<String, Integer> prices = new HashMap<>();
        System.out.println("Prices map: " + prices);
        prices.merge("fruits", 3, Integer::sum);
        prices.merge("fruits", 5, Integer::sum);
        System.out.println("Prices map: " + prices);

        System.out.println("====================================");
        // null removes mapping for the key:
        prices.merge("fruits", 7, (oldVal, newVal) -> {
            System.out.printf("Old val: %d, new val: %d%n", oldVal, newVal);
            return newVal;
        });
        System.out.println("Prices map: " + prices);


        System.out.println("====================================");

        prices.put("veggies", null);
        System.out.println("Prices map: " + prices);
        prices.merge("veggies", 42, Integer::sum);
        System.out.println("Prices map: " + prices);
    }
}
