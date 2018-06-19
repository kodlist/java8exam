package Stream;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


class Item{
	
	String name;
	int qty;
	BigDecimal price;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public Item(String name, int qty, BigDecimal price) {
		super();
		this.name = name;
		this.qty = qty;
		this.price = price;
	}
	
	
	
}
public class StreamCollectorsGroupingby {
	
	public static void main(String[] args) {
		
		
		List<String> itemsA =
                Arrays.asList("apple", "apple", "banana",
                        "apple", "orange", "banana", "papaya");
		
		
		Map<String, Long> map1 = itemsA.stream().collect(Collectors.groupingBy(Function.identity() ,  Collectors.counting()));
		System.out.println(map1);
		
		Map<String, Long> map2 = new LinkedHashMap<>();
		
		map1.entrySet().stream()
						. sorted(Map.Entry.<String, Long> comparingByValue().reversed() )
						. forEachOrdered(e -> map2.put(e.getKey(), e.getValue()));
		
		System.out.println(map2);
		
		List<Item> itemsB = Arrays.asList(
                new Item("apple", 10, new BigDecimal("9.99")),
                new Item("banana", 20, new BigDecimal("19.99")),
                new Item("orange", 10, new BigDecimal("29.99")),
                new Item("apple", 20, new BigDecimal("9.99"))
        );
		
		Map<String, Long> counting = itemsB.stream().collect(
                Collectors.groupingBy(Item::getName, Collectors.counting()));

        System.out.println(counting);

        Map<String, Integer> sum = itemsB.stream().collect(
                Collectors.groupingBy(Item::getName, Collectors.summingInt(Item::getQty)));

        System.out.println(sum);
		
		
	}

}
