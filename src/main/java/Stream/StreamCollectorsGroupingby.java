package Stream;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

class BookX {
	private String title;
	private String genre;

	public BookX(String title, String genre) {
		this.title = title;
		this.genre = genre;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
}
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
		System.out.println("=========== line 63 ===========");
		System.out.println(map2);
		
		List<Item> itemsB = Arrays.asList(
                new Item("apple", 10, new BigDecimal("9.99")),
                new Item("banana", 20, new BigDecimal("19.99")),
                new Item("orange", 10, new BigDecimal("29.99")),
                new Item("apple", 20, new BigDecimal("9.99"))
        );
		System.out.println("===========line 72 ============");
		Map<String, Long> counting = itemsB.stream().collect(
                Collectors.groupingBy(Item::getName, Collectors.counting()));

        System.out.println(counting);

        Map<String, Integer> sum = itemsB.stream().collect(
                Collectors.groupingBy(Item::getName, Collectors.summingInt(Item::getQty)));
		System.out.println("===========line 80 ============");
		System.out.println(sum);
		

		List<BookX> bkx = Arrays.asList( new BookX("Title1", "Comedy"), new BookX("ABCTitle", "Drama"));


		 Comparator<BookX> c1 =  (b1, b2)->b1.getGenre().compareTo(b2.getGenre());
		bkx.stream().sorted(c1).forEach(x-> System.out.println(x.getGenre() +" : "+ x.getTitle()));
		System.out.println("=========== line 110 ==========");
			bkx.stream().sorted(c1.thenComparing(BookX::getTitle));

		bkx.forEach( x-> System.out.println(x.getGenre() +" :  "+ x.getTitle()));
		System.out.println("=============line 113 =========");
		//bkx.forEach( x-> System.out.println(x.getGenre() +" : "+ x.getTitle()));
		System.out.println("======line 115 =======");

		c1 =  (b1, b2)->b2.getGenre().compareTo(b1.getGenre());
		System.out.println("========line 119 ==========");
		bkx.stream().sorted(c1).forEach(x-> System.out.println(x.getGenre() +" : "+ x.getTitle()));
		bkx.stream().sorted(c1.thenComparing(BookX::getTitle));
		bkx.forEach( x-> System.out.println(x.getGenre() +" :  "+ x.getTitle()));
		System.out.println("=========line 118 =======");
		bkx.forEach( x-> System.out.println(x.getGenre() +" : "+ x.getTitle()));
	}

}
