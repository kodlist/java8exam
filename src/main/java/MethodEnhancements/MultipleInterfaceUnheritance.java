package MethodEnhancements;

/**
 * Created by mkoduri on 7/2/2018.
 *
 *
 * Default Method and Multiple Inheritance Ambiguity Problems
 */

interface GreeterIntf1{
    void greet();

    default public void greet2() {
        System.out.println("Hi");
    }
}
interface GreeterIntf2{
    void greet();

    default public void greet2() {
        System.out.println("Hello");
    }
}

public class MultipleInterfaceUnheritance  implements  GreeterIntf1 , GreeterIntf2{

    @Override
    public void greet() {

    }

    @Override
    public void greet2() {
        GreeterIntf1.super.greet2();  // remember about "super" in the class
    }

    public static void main(String[] args) {

        MultipleInterfaceUnheritance obj1 = new MultipleInterfaceUnheritance();

        obj1.greet2();




    }
}
