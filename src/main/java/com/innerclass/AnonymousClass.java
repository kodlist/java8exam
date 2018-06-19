package com.innerclass;

interface XClass{
	
	int h = 4;
	static int j = 9;  
	//(Variables can be defined in interfaces, but they do not behave as might be expected: they are treated as final static.
	void m2()
	;
}

class ABC{
	int i =33;
	static int y = 55;
}
public class AnonymousClass  {
	
	/**/
	
	public static void main(String[] args) throws InterruptedException {
		
		XClass x = new XClass() {
			
			public void m2() {
				System.out.println(h +"  "+j);
			}
			
		};
		x.m2();  // the advantage of anonymous class is that we dont have to create a separate class
				// or implement interface just for calling m2 method. we can just make anonymous class and call m2 method.
		
		
		
		// another example - creating a thread
		//Here we are using Anonymous Inner class
        //that extends a class i.e. Here a Thread class
        Thread t = new Thread()
        {
            public void run()
            {
                System.out.println("Child Thread");
            }
        };
        t.start();
        System.out.println("Main Thread");
        
        
        
        Runnable r = new Runnable()
        {
            public void run()
            {
                System.out.println("Child Thread");
            }
        };
        
        
        // ************* Lambda Runnable ***************//
        
        Runnable task3 = () -> {
            System.out.println(Thread.currentThread().getName() + " is running");
        };
 
        new Thread(task3).start();
        
        
      //lambda expression to create the object
        
        new Thread(()->
           {System.out.println("New thread created");}).start();
    
         
        System.out.println("=  Main Thread");
        
      // ************************** ***************//
        
    }
	
	
		
		
		
	}
	
	
	


