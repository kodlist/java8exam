package com.innerclass;

interface Hub{
	
	void doAction();
}

public class ReplaceAnonymousInnerClass {
	
	public void doH( Hub h) {
		h.doAction();
		
	}
	
	public void doDf(DF df)
	{
		//df.dfm();
	}
	
	public static void main(String[] args) {
		
		
		System.out.println(Thread.currentThread().getName() + ": RunnableTest");
		 
        // Anonymous Runnable
 
        Runnable task1 = new Runnable(){
 
          @Override
          public void run(){
            System.out.println(Thread.currentThread().getName() + " is running");
          }
        };
 
 
        // Passing a Runnable when creating a new thread
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run(){
                System.out.println(Thread.currentThread().getName() + " is running");
            }
        });
 
        
        //**********************LAMBDA **********************************************
 
        // Lambda Runnable
        Runnable task3 = () -> {
            System.out.println(Thread.currentThread().getName() + " is running");
        };
 
        Thread thread1 = new Thread(task1);
 
        thread1.start();
        thread2.start();
 
        new Thread(task3).start();
        
        
      //lambda expression to create the object
        new Thread(()->
           {System.out.println("New thread created");}).start();
		
		//*************************************************************************

		
		
	}
	

}
@FunctionalInterface
interface DF {
	
	default void dfm()
	{
		//System.out.println("dfm");
		//System.getProperty("");
	}
	public void doX();
	default void setV(String userdir)
	{
		System.out.println("user dir");
	}
}

class X implements Hub{

	//DF df = new DF();
	@Override
	public void doAction() {
		
		//System.getProperty("user.dir");
	//	df.dfm();
		
	}
	
}
