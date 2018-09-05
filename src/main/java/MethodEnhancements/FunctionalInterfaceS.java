package MethodEnhancements;

/**
 * Created by mkoduri on 9/4/2018.
 */


@FunctionalInterface
interface interfOne{
    public  default void method1()
    {

    }

    public  default void method12()
    {

    }
    //Single abstract method  - atleast one abstract method should exist if you use @FunctionalInterface annotation
    public void firstMethod();

    //public void secMethod();  - when you mark interface functionalinterface annotation, you can only have one abstract method

    public static void method2(){}

}
public class FunctionalInterfaceS implements interfOne{

    @Override
    public void firstMethod() {
        System.out.println(" in line 26");
    }

    public void method2( interfOne i)
    {
        i.firstMethod();
    }

    public static void main(String[] args) {

        /*Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println();
            }
        };

        Thread t1 = new Thread( r);


        Thread t2 = new Thread(   () -> System.out.println("----") );
        */
        interfOne i1 = new interfOne() {
            @Override
            public void firstMethod() {
                System.out.println("====");
            }
        };

        interfOne  i2 = () -> System.out.println(" in am implementing abstarct method");

        interfOne is = new FunctionalInterfaceS();
        is.firstMethod();

        FunctionalInterfaceS fs = new FunctionalInterfaceS();
        fs.method2(i2);

    }
}
