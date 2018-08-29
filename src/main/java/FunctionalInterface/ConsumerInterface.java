package FunctionalInterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.stream.IntStream;


/**
 *
 *
 *
 *
 		@FunctionalInterface
 		public interface Consumer<T extends Object> {

					 public void accept(T t);
 		}

 *
 *
 *
 *
 */
public class ConsumerInterface {
	
	public static void main(String args[]) {
		
	    Consumer<Integer> consumer= i-> System.out.print(" "+i);
	    List<Integer> integerList=Arrays.asList(new Integer(20), 
	                              new Integer(10), new Integer(30),
	                              new Integer(1), new Integer(-30),
	                              new Integer(0));
	    printList(integerList, consumer);
	    
	    System.out.println(" \n===============");
	    //example 2
	    Consumer<Integer> consumer2 ;//= Integer:: new;
	    consumer2 = i-> System.out.println(""+i);
	    consumer2.accept(222);


		Consumer<String> c = (x) -> System.out.println(x.toLowerCase());
		c.andThen(c).accept("Java2s.com");


		BiPredicate<Integer, Integer> bi = (x, y) -> x > y;

		BiPredicate<Integer, Integer> eq = (x, y) -> x -2 > y;

		System.out.println(bi.test(2, 3));
		System.out.println(bi.and(eq).test(6, 3));

		IntStream.range(1, 3).forEach(i -> System.out.println(i));
// > 1, 2
		IntStream.rangeClosed(1, 3).forEach(i -> System.out.println(i));
// > 1, 2, 3
		System.out.println("---");
		IntStream.range(1, 5).map(i -> i * i).forEach(i -> System.out.println(i));


		//---- prior java 8
		System.out.println("----- prior java 8 ---");
		for(int i = 0; i<4; i++)
		{
			System.out.println(i);
		}
		System.out.println("----- from java 8 ---");
		IntStream.range(0, 4).map(i -> i ).forEach(i -> System.out.println(i));


	}
	
	
	 public static void printList(List<Integer> listOfIntegers, Consumer<Integer> consumer){
	  for(Integer integer:listOfIntegers){
	    consumer.accept(integer);
	  }
	 }



}
