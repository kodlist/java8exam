package com.innerclass;

public class BasicStaticInner {
	
	int a = 33;
	
	static class InnerClass{
		
		static int i =2;
		int x = 4;
		
		// a is not accessible with m1(), but if it is static then it is accessible.
		//public void m1() {System.out.println("method 1 in inner class of Employee  "  + a + " "+ i);}
		
		
	}
	
	public static void main(String[] args) {
		BasicStaticInner.InnerClass bi = new BasicStaticInner.InnerClass();
		
		System.out.println(bi.x +"  "+ bi.i);
		
		// a is not accessible with bi.
		
		BasicStaticInner.InnerClass bi1 = new InnerClass();
		
		System.out.println(bi1.x +"  "+ bi1.i);
		//System.out.println(bi1.a);
	}

}
