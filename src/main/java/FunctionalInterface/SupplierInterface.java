package FunctionalInterface;

import java.util.Date;
import java.util.function.Supplier;

//source code copied
/*@FunctionalInterface
public interface Supplier<T> {
    *//**
     * Gets a result.
     * @return a result
     *//*
    T get();
}*/



public class SupplierInterface {
	
	public static void main(String[] args) {
		
		//Example one 
		
		Supplier<String> SupplierStr1 = () -> new String("Hello");
	    String str = SupplierStr1.get();
		System.out.println("String in helloStr is->"  + str +  "<-");
		
		
		//Example two
		
		Supplier<String> SupplierStr2 = String::new; // this code of line is implementation of get method (inside) of supplier interface.
		String emptyStr = SupplierStr2.get();
		System.out.println("String in emptyStr is->"+emptyStr+"<-");
		   
		
		 // Example three
		
		 Supplier<Date> dateSupplier= SupplierInterface::getSystemDate; // this code of line is implementation of get method (inside) of supplier interface.
		 Date systemDate = dateSupplier.get();
		 System.out.println("systemDate->" + systemDate);
		 }
	
		 public static Date getSystemDate() {
		  return new Date();
		 }

}
