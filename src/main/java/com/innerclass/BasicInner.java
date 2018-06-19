package com.innerclass;

public class BasicInner {
	static int z = 3;
	int u = 44;
	class Employee{
		//static int x = 2;  // it should be final static or no static
		final static int y = 2;
		public void m1() {System.out.println("method 1 in inner class of Employee  "  + u + " "+z);}
	}
	
	public static void main(String[] args) {
		
		BasicInner b = new BasicInner();
		BasicInner.Employee be = b.new Employee();
		System.out.println(be.y + " "+ Employee.y);
		be.m1();
		
		System.out.println(b.z );
		System.out.println(z);
	}

}
