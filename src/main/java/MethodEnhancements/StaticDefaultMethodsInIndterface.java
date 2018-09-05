package MethodEnhancements;

/**
 * Created by mkoduri on 7/2/2018.
 *
 * Quote from JLS 8: "An interface can declare static methods, which are invoked without reference to a particular object."
 *
 *
 */
interface FooInterface{
    public  static void methodx(){
        System.out.println( "in static methodx");
    }
    public default void methodD(){
        System.out.println(  "FooInterface :In default methodD");
    }

    public default void methodDX(){
        System.out.println(  "FooInterface :In default methodDX");
    }

    public static void methody()
    {
        System.out.println(" in staitc of FooInterfcae");
    }
}

interface SubFooInterface extends FooInterface{

   // public default void methodx(){        System.out.println( "In default methodx");    }
    /*public static void methodD(){
        System.out.println("In static methodD");    // THIS doesnt compile
    }*/

    public default void methodXX(){
        System.out.println( "In default methodX");
    }

    public default void methodD(){
        System.out.println("SubFooInterface : In default  methodD");
    }


    public static void methody()
    {
        System.out.println(" in staitc of SubFooInterfcae");
    }

    public static void methodz()
    {
        System.out.println(" in staitc of SubFooInterfcae");
    }
}

interface Doable{

    static void doIt(){
        System.out.println("Doing it...");
    }
}

class Task implements Doable{

}


public class StaticDefaultMethodsInIndterface {

    public static void m1()
    {
        FooInterface.methodx();
    }

    public static void m2( SubFooInterface sf)
    {
       // sf.methodx();
       // SubFooInterface.methodx();
    }

    public static void main(String[] args) {

        //Doable d = new Task(); //this code fails
        // d.doIt();

        //Task t = new Task(); //thie code fails
        // t.doIt();

        //Task.doIt();

        //Only this code compiles and runs (the implements does not play any role here):

        m1();
        System.out.println("============");

        FooInterface fs = new SubFooInterface() {   };

        //m2(fs);

        SubFooInterface fs1 = new SubFooInterface() {        };
        m2(fs1);

    }
}
