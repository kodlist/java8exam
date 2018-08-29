package FunctionalInterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/*

@FunctionalInterface
public interface Predicate<T extends Object> {

    public boolean test(T t);

    ...

}

 */


interface UserY{
	public void m1(String x, String y);
	//public void m2();    not valid to declare two abstract methods for FunctionalInterface in JAVA 8
}


public class PredicateInterface {
	
	public static void main(String[] args) {
		
		List<String> names =
	            Arrays.asList("Sopie", "Dan", "Sarah", "George", "Shan");
		
		Predicate<String> p = (s)->s.startsWith("S");
		
		 // PRE JAVA 8
		for(String st: names)
		{
			if(p.test(st))
			{
				System.out.println(st);
			}
		}
		
	   	
	  // FROM JAVA 8
		names.stream().filter((s)-> s.startsWith("S") ).collect(Collectors.toList()).forEach(System.out::println);;
	
		System.out.println("========================");
		
	 // 	Second example of java 8
		UserY y = (k, m)->{System.out.println("Anonymous in lambda :  " + k +"  "+m);};
		y.m1("jenny", "k");
		
	  
	 
		// other sub interfaces
		IntPredicate i = (x)-> x ==123;
	    
	    IntPredicate j = (x)-> x ==124;
	    
	    System.out.println(i.and(j).test(123));
		
		
		
	}

}
