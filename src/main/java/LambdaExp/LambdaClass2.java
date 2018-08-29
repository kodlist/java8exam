package LambdaExp;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class LambdaClass2 {

	
	public static void main(String[] args) {
		
		char[] c = {'c', 'a','t'};   
		String s = new String(c);            /* <-------------  Line 10 and 11 */
		System.out.println(s);
		
		
		Function<char[], String> f1 = (arr) -> new String(arr);  /* <-------------  Line 15 is equal to line 10 & 11 -----------*/
		
		System.out.println(  f1.apply( new char[] {'H', 'i'}  )  );
		
		
		
		// Java compiler infers the right constructor to call based
		// on the context in which the constructor reference appears

		Function <char[], String>       f2 = String::new;     /* <-------------  Line 24 is equal to line 15 and line 10 & 11 -------- */
		Function <StringBuffer, String> f3 = String::new;

		System.out.println( f2.apply(new char[] {'H', 'i'})   );
		System.out.println( f3.apply(new StringBuffer().append("Hello"))  );
		
		
		
		BiFunction<String, String, Boolean> f4 = (s1, s2) -> s1.equalsIgnoreCase(s2);   /* <------ The second parameter type (Boolean) of generic is output type. */
		System.out.println(f4.apply("Hello", "HELLO"));
		
		BiFunction<String, String, Boolean> f5 = String::equalsIgnoreCase;
		System.out.println(f5.apply("Hello", "HELLO"));
		
		
		//String::trim is equivalent to lambda (String str) -> { return str.trim(); }.
		
		Function <String, String>       f6 = String::new; 
		System.out.println(  f6.apply("jack"));
		
	    Function <String, String>   f7 = String::new ;     /* <------ The second parameter type of generic is output type. */
	    System.out.println(  f7.apply(" jack".trim()));
	    
	    Function <String, String> f8 = (String s2) -> { return s.trim() ;}  ;     /* <------ The second parameter type (String) of generic is output type. */
	    
	    
	    Function <String, String>       f9 = String::toUpperCase; 
		System.out.println(  f9.apply("jack"));



		String val1 = "hello";
		//val1 = val1+"jj";
		StringBuilder val2 = new StringBuilder("world");
		UnaryOperator<String> uo1 = s1->s1.concat(val1);
		//A lambda expression in a method can make use of a local variable if it is declared as final or if it is effectively final.
		// It basically means that a variable that is not declared final can still be considered as final if its value is never changed in the program.
		//Therefore, you can use val1 in the lambda expression at line 60 (  uo1 )
		
		
		
	}
}
