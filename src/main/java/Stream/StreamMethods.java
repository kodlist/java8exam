package Stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by mkoduri on 8/4/2018.
 */

class ItemX{
    private String name;
    private String category;
    private double price;
    public ItemX(String name, String category, double price){
    this.name = name;
    this.category = category;
    this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
public class StreamMethods {

    public static void main(String[] args) {



        List<String> values = Arrays.asList("Alpha A", "Alpha B", "Alpha C");
        boolean flag = values.stream().allMatch(str->str.contains("Alphax"));
        System.out.println("======== line 57 =======  : "+flag);

        boolean flag1 = values.stream().findFirst().get().startsWith("Alp");
        System.out.println(flag1);
        boolean flag2 = values.stream().findAny().get().contains("Alpha");
        System.out.println(flag2);


        List<Integer> ls = Arrays.asList(10, 47, 33, 23);

        ls.stream().max(Comparator.comparing(a->a)).get();
        System.out.println(" ========== line 67 ======= "+  ls.stream().max(Comparator.comparing(a->a)).get().intValue());
        System.out.println("=====line 68 =========");
        ls.stream().reduce((a, b)->a>b?a:b);

        System.out.println("=====line 71 =========");

        List<ItemX> items = Arrays.asList( new ItemX("Pen", "Stationery", 3.0),
                new ItemX("Pencil", "Stationery", 2.0),
                new ItemX("Eraser", "Stationery", 1.0),
                new ItemX("Milk", "Food", 2.0),
                new ItemX("Eggs", "Food", 3.0) );

        ToDoubleFunction<ItemX> priceF = ItemX::getPrice;
        //Map<String, List<Stream.ItemX>> map;
        Map<String, List<ItemX>> map = items.stream().collect(  Collectors.groupingBy(ItemX::getCategory));

        map.forEach( (x, y) -> System.out.println(   " line 84 : "+ x  + " :  "  + y ));
       // map.forEach(  (x,y) -> System.out.println(  y.forEach( z -> System.out.println( z.getName())   )));

        map = items.stream().collect(  Collectors.groupingBy(s-> s.getCategory()));
        map.forEach( (x, y) -> System.out.println(   " line 88 : "+ x  + " :  "  + y ));
        System.out.println("====================line 85 =======");
        map.get("Stationery").forEach(c -> System.out.println(c.getName()+ " : "+c.getPrice() +" : "+c.getCategory()));

        System.out.println("======== line 92 ========");

        map.forEach(  (a, b)  -> {
            double avg = b.stream().collect( Collectors.averagingDouble(  priceF));
            System.out.println(  a+ "  "+avg);

        }  );

        System.out.println("======== line 100 =========");


        List<Character> ratings = Arrays.asList('U', 'R', 'A');


        //map takes Function  - Intermediate operation
        //peek takes Consumer  - Intermediate operation
        //filter takes Predicate  - Intermediate operation

        //forEach takes Consumer - Terminal operation

        System.out.println("=======line 110 =========");
        ratings.stream().filter(x->x=='A').peek(x -> System.out.println( "old rating " + x)).map( r -> { System.out.println(r) ; return r;}) ;


        System.out.println("======line 116  =");

        List<String> letters = Arrays.asList("j", "a", "v","a");


        String word = letters.stream().reduce("", (a, b)->a.concat(b));
        System.out.println(word);

    }
}
