package FunctionalInterface;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.function.Function;
import java.util.function.UnaryOperator;

//source code copied =========== Function Interface ==========
/*public interface Function<T, R> {
    R apply(T t);
    default <V> Function<V, R> compose(Function<? super V, ? extends T> before) {
        Objects.requireNonNull(before);
        return (V v) -> apply(before.apply(v));
    }
    default <V> Function<T, V> andThen(Function<? super R, ? extends V> after) {
        Objects.requireNonNull(after);
        return (T t) -> after.apply(apply(t));
    }
    static <T> Function<T, T> identity() {
        return t -> t;
    }
}*/

class Customer{
	
	int id;
	String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	Customer(String name, int id)
	{
		this.name = name;
		this.id = id;
		
	}
	
}



public class FunctionInterface {
	
	public static void main(String[] args) {
		
		Function<Customer, String> fcs= (Customer c) -> {return c.getName();} ;
		
		List<Customer> cstList = Arrays.asList(new Customer("John", 32), new Customer("FIona", 23));
		
		List<String> cstNameLsit = convertCustomersToNamesList(cstList, fcs);
		
		cstNameLsit.forEach(System.out::println);


		System.out.println("============== String manipulation -=============");

		String name = "bob"; String val = null;

		Function<Locale, String > f = name::toUpperCase;
		val = f.apply(Locale.CANADA);
		System.out.println( "val : "+ val);





	}
	
	
	public static List<String> convertCustomersToNamesList(List<Customer> cstList, Function<Customer, String> funcCstToString){
		   List<String> cstNameList=new ArrayList<String>(); 
		   for(Customer cst:cstList){
			  
			   cstNameList.add(funcCstToString.apply(cst));
		   }
		   
		   return cstNameList;
	}
	
	
	
	
	

    
  
}
