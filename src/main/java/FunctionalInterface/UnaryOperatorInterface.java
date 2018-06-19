package FunctionalInterface;

import java.util.function.IntPredicate;
import java.util.function.UnaryOperator;

public class UnaryOperatorInterface {
	
	public static void main(String[] args) {
		
		UnaryOperator<Integer> operator = t -> t * 2 ;
		
		System.out.println(  operator.apply(4));
		
		System.out.println(operator.apply(3));
		
		
		UnaryOperator<Integer> operator1 = t -> t + 2 ;
		
		int a = operator1.andThen(operator1).apply(5);
		System.out.println(a);
		
		
		// Using compose()
		int b = operator1.compose(operator1).apply(5);
		System.out.println(b);
				
		
		
				
	}

}
