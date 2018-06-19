package LambdaExp;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaInCollections {
	
	public static void main(String[] args) {
		
		List<String> items = new ArrayList<>();
		items.add("A");
		items.add("B");
		items.add("C");
		items.add("D");
		items.add("E");

		//*********lambda********************************
		items.forEach(item->System.out.println(item));  System.out.println("\n");
		//***********************************************// 
		items.forEach(System.out::println);
		//***********************************************
		
		int i = items.stream().toArray().length;   System.out.println("=========");
		System.out.println(i);
		
			
	}

}
