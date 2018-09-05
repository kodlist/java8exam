package com.staticmethods;

/**
 * Created by mkoduri on 9/4/2018.
 */

interface intr1
{
    public static void m2(){
        System.out.println(" line 10 ");
    }
}
interface  intr2 extends intr1{

}
class ClassOnx{

    public static void m1(){
        System.out.println(" line 10 ");
    }
}

class ClassOny extends  ClassOnx{
    /*public static void m1(){
        System.out.println(" line 16 ");
    }*/
}
public class ClassOn {

public void m1()
{
    ClassOnx.m1();
    ClassOny.m1();
}

public void m2()
{
    intr1.m2();
    //intr2.m2();
}

    public static void main(String[] args) {

        ClassOny.m1();
        ClassOnx.m1();


    }
}
