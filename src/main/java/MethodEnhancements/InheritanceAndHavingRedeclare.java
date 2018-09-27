package MethodEnhancements;

import java.util.function.Predicate;

/**
 * Created by mkoduri on 9/22/2018.
 */

interface Account{


    public default String getId(){ return "" ;}

    public static void m1(){}

    public void m2();
}
interface PremiumAccount extends Account{
    //public static String getId(){ return "" ;}
    public static void m1(int i){}

    public default void m1(){}

    public default void m2(){         System.out.println("m2 ----- sub interface");    }
    // this line tells I have implemented m2() method of Account, so InheritanceAndHavingRedeclare doesn't have to implement.


}
public class InheritanceAndHavingRedeclare implements PremiumAccount{


    public static void main(String[] args) {


    }
}
