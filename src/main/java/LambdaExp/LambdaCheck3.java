package LambdaExp;

import java.util.function.IntFunction;
import java.util.function.Supplier;

class Section{
	
	String secA;
	int secI;
	public String getSecA() {
		return secA;
	}
	public void setSecA(String secA) {
		this.secA = secA;
	}
	public int getSecI() {
		
		return secI;
	}
	public void setSecI(int secI) {
		this.secI = secI;
	}
	
}

public class LambdaCheck3 {
	
	public static void main(String[] args) {
		
		Integer i = new Integer(1);

		Supplier<String> f1 = () -> i.toString();
		System.out.println(f1.get());
		
		Integer i1 = new Integer(4);

		Supplier<String> f2 = i1::toString;
		System.out.println(f1.get());
		
		//Supplier<Section> sec = Section::setSecA( Section) ;
		//Supplier<Section> sec = (s1)-> s1.
		
		
		IntFunction<String> f4 = String::valueOf;
		System.out.println(f4.apply(100));
		

	}

}
