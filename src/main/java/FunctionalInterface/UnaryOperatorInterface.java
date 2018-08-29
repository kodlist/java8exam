package FunctionalInterface;

import java.util.function.IntPredicate;
import java.util.function.UnaryOperator;


/*
	@FunctionalInterface
		public interface UnaryOperator<T extends Object> extends Function<T, T> {

    ...

}

 */

interface  xyz{

	public void m1();

}
public class UnaryOperatorInterface implements xyz{
	@Override
	public void m1() {
		int x =9;

		if (x == 2) {
			x=7;
			System.out.println(x);
		}
	}

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



		String val1 = "hello";
		StringBuilder val2 = new StringBuilder("world");
		UnaryOperator<String> uo1 = s1->s1.concat(val1);

		UnaryOperator<String> uo2 = s->s.toUpperCase();
		//System.out.println(uo1.apply(uo2.apply(val2)));

		String se = new String();
		int i =3;

	}

}
