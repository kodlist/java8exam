package FunctionalInterface;

/**
 * Created by mkoduri on 7/26/2018.
 */

interface MyGeneral<E,T>{

    String s  = new String("mehar");
    Integer i = new Integer(22);
    //T tvar ;

    void method1(E e, T t);
    T getMethod2();


}
public class GeneralInterfaceWithMethods {

    public static void main(String[] args) {

        MyGeneral<String, Integer> objG = new MyGeneral<String, Integer>() {
            @Override
            public void method1(String s, Integer integer) {

            }

            @Override
            public Integer getMethod2() {
                return i.intValue();
            }
        };

        objG.getMethod2();

    }
}
