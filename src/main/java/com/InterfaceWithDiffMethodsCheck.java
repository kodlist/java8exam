package com;

import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

/**
 * Created by mkoduri on 9/19/2018.
 */

interface AccountL{

    public default String getId(){
        System.out.println("00");
        return "00";
    }

   /* public static String getId(){             // doesnt work
        System.out.println("00");
        return "00";
    }*/
}
interface PublicAccount extends AccountL{

//    String getId(); abstarct method with same name as of super interface  works

   /* public static String getId(){
        return "33";                 // doesnt work
    }*/

    //String getId();  // if you don't have another or duplicate method name in same  interface then this works.
                       //An interface can redeclare a default method and also make it abstract.

   public default String getId(){
       System.out.println("44");   //this works
       return "44";
   }
}
public class InterfaceWithDiffMethodsCheck implements AccountL, PublicAccount{


    static void m1(AccountL a)
    {
        a.getId();
    }
    public static void main(String[] args) {

        AccountL A = new InterfaceWithDiffMethodsCheck();
        PublicAccount aa = new InterfaceWithDiffMethodsCheck();

        m1(A);
        m1(aa);


        UnaryOperator<String> uo = str->str.toUpperCase();
        List<String> letters = Arrays.asList("j", "a", "v","a");
        letters.replaceAll(uo);

        System.out.print(letters.stream().collect( Collectors.joining()).toUpperCase() );
    }
}
