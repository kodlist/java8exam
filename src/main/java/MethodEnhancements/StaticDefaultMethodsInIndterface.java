package MethodEnhancements;

/**
 * Created by mkoduri on 7/2/2018.
 *
 * Quote from JLS 8: "An interface can declare static methods, which are invoked without reference to a particular object."
 *
 *
 */

interface Doable{

    static void doIt(){
        System.out.println("Doing it...");
    }
}

class Task implements Doable{

}


public class StaticDefaultMethodsInIndterface {

    public static void main(String[] args) {

        //Doable d = new Task(); //this code fails
        // d.doIt();

        //Task t = new Task(); //thie code fails
        // t.doIt();

        //Task.doIt();

        //Only this code compiles and runs (the implements does not play any role here):
        Doable.doIt();

    }


}
