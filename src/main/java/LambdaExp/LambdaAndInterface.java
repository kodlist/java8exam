package LambdaExp;

import java.io.IOException;
import java.io.OutputStream;

@FunctionalInterface
interface MyInterface {

    void printIt(String text);

    default public void printUtf8To(String text, OutputStream outputStream){
        try {
            outputStream.write(text.getBytes("UTF-8"));
        } catch (IOException e) {
            throw new RuntimeException("Error writing String as UTF-8 to OutputStream", e);
        }
    }

    static void printItToSystemOut(String text){
        System.out.println(text +" -----");
    }
    
    default void doitx()
    {
    	System.out.println("gggg");
    }
    
    
}
public class LambdaAndInterface {
	
	public void doit()
	{
		
	}
	
	public static void main(String[] args) {
		
		
		MyInterface myInterface = (String text) -> {
		    System.out.print(text);
		};
		
		myInterface.printIt("ffff");
		
		LambdaAndInterface l = new LambdaAndInterface();
		
		//LambdaAndInterface l1 = () -> System.out.println("Zero parameter lambda"); 
		//to write lambda , class has ot be interface
		
		//MyInterface myInterfaceA  = () -> System.out.println(); //failure
}
	
}
