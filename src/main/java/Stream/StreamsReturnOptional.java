package Stream;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;

public class StreamsReturnOptional {
	
	public static void main(String[] args) {
		
		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(33);
		list1.add(222);
		list1.add(100);
		
		OptionalInt o = list1.stream().mapToInt(j -> j).max() ;
		
		System.out.println(o.getAsInt());
		
		
	}

}
