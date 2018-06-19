package Stream;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class StreamMaxMin {
	
	public static void main(String[] args) {
		
		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(2);
		list1.add(4);
		list1.add(2);
		
		int i = list1.stream().mapToInt(j -> j).max().getAsInt();
		System.out.println(i);
		
		System.out.println("============MAX & MIN ============");
		System.out.println(list1.stream().max(Integer::compare).get());
		System.out.println(list1.stream().min(Integer::compare).get());
		
		System.out.println("========================");
		
		/** the average is for 3 places in the list not with the values in list. the list1 is of size of 3.  **/
		System.out.println(list1.stream().mapToInt(j -> j).average().getAsDouble());
		
		
		System.out.println("============Double 1============");
		
		List<Double> NUMBERS_FOR_AVERAGE = new ArrayList<Double>();
		
		NUMBERS_FOR_AVERAGE.add(new Double(10));
	    NUMBERS_FOR_AVERAGE.add(new Double(10));
	    NUMBERS_FOR_AVERAGE.add(new Double(10));
	    NUMBERS_FOR_AVERAGE.add(new Double(10));
		
	    /** the avg is for size of list NUMBERS_FOR_AVERAGE not the values. **/  
		
		OptionalDouble average = NUMBERS_FOR_AVERAGE
	                            .stream()
	                            .mapToDouble(a -> a)
	                            .average();
		
		System.out.println(average.getAsDouble());
		
		System.out.println("==========Double 2==============");
		double d = NUMBERS_FOR_AVERAGE
                                   .stream()
                                   .collect(Collectors.averagingDouble(Double::doubleValue));
		
		System.out.println(d);
		
		System.out.println("========== Integer list summing ==============");
		
		List<Integer> Numbers_forSum = new ArrayList<Integer>();
		
		Numbers_forSum.add(new Integer(10));
		Numbers_forSum.add(new Integer(10));
		Numbers_forSum.add(new Integer(10));
		
		int i1 = Numbers_forSum.stream().mapToInt(k -> k.intValue()).sum();
		int i2 = Numbers_forSum.stream().mapToInt(Integer::intValue).sum();
		
		int i3 = Numbers_forSum.stream().collect(Collectors.summingInt(Integer::intValue));
		
		System.out.println(i1 +"  "+ i2 + " "+i3);
		System.out.println("========================");
		
		
		// such as averagingDouble(), groupingBy(), joining(), and partitioningBy()
		
		
		
		
	}

}
