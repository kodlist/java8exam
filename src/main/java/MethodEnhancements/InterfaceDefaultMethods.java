package MethodEnhancements;

/**
 * Created by mkoduri on 7/2/2018.
 */

interface GreeterIntf{


    default public void greet()
    {
        System.out.println("hi");
    }

    /*public void greetS()
    {
        System.out.println("hi");  / THIS METHOD WONT COMPILE UNLESS YOU PUT DEFAULT
    }*/
}
class Greeter implements  GreeterIntf{
    /*@Override
    public void greet()
    {
        System.out.println("hi nn");  // THIS WILL COMPILE
    }*/

}
public class InterfaceDefaultMethods {

    public static void main(String[] args) {

        Greeter g = new Greeter();
        g.greet();
    }


}
