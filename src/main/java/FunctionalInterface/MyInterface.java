package FunctionalInterface;


//*******************************************************//

interface YInterface{	
	default void m1() {}  // 
	//A default method is an instance method defined in an interface whose method header begins with the default keyword; it also provides a code body. 
	//Every class that implements the interface inherits the interface's default methods and can override them.
	 
	void m2();
}

//*******************************************************//

//*******************************************************//

//Since functional interface requires a single abstract method, 
//this code will NOT compile, as it is invalid functional interface:
// removing "@FunctionalInterface" will compile. or you have to define abstract method also.

/*@FunctionalInterface
interface ZInterface{
	default void m1() {}  
	
}*/

//********************************************************//

@FunctionalInterface
interface ZInterface{
	default void m1() {}  
	void doItNow(); // Single Abstract Method (SAM)
}


interface XInterface{	
	public void doit();
}


@FunctionalInterface
interface GInterface{
	static void dox() {}
	//public void doI() {} // this will be compile fail
	public void doY();
	
}

public class MyInterface implements ZInterface , GInterface{

	@Override
	public void doItNow() {
		// TODO Auto-generated method stub
		
	}
	
	public  void m1() { System.out.println("default method implementation of ZInterface");}

	@Override
	public void doY() {
		 System.out.println("default method implementation of GInterface");
		
	}  
	
	

}
