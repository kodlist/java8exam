package FunctionalInterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

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
	    Consumer<Integer> consumer2 = Integer:: new;
	    consumer2 = i-> System.out.println(""+i);
	    consumer2.accept(222);
	    
	 }
	
	
	 public static void printList(List<Integer> listOfIntegers, Consumer<Integer> consumer){
	  for(Integer integer:listOfIntegers){
	    consumer.accept(integer);
	  }
	 }

}
