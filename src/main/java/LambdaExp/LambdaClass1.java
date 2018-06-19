package LambdaExp;

interface UserY{
	public void m1(String x, String y);
	//public void m2();    not valid to declare two abstract methods for FunctionalInterface in JAVA 8
}

@FunctionalInterface
interface UserX{
	
	default void m1() { System.out.println(Thread.currentThread().getName());}
	public void m2();
	//public void m3(String t); not valid to declare two abstract methods for FunctionalInterface in JAVA 8
	
}

class UserC{
	int age =18;
	int getAge(int i) {return age;}
}

//Java program to demonstrate lamda expressions to implement
//a user defined functional interface.

@FunctionalInterface
interface Square
{
	int calculate(int x);
}
public class LambdaClass1{
	public static void main(String[] args) {
		
		UserX x = ()-> {System.out.println("ANONYMOUS IN LAMBDA ....");  };
		x.m2();
		x.m1();
		
		UserY y = (k, m)->{System.out.println("Anonymous in lambda :  " + k +"  "+m);};
		y.m1("jenny", "k");
		
		
		 Square s = (int i)->i*i;
		 
		 int j = s.calculate(3);
		 System.out.println(j);
	}

}
