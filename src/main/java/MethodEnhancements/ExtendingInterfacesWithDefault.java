package MethodEnhancements;

/**
 * Created by mkoduri on 7/2/2018.
 */

interface Intf1{
    default void method(){ }
}
interface  Intf2 extends Intf1{
    @Override
    abstract void method();
}

public class ExtendingInterfacesWithDefault {
}
