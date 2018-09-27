package LambdaExp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mkoduri on 9/24/2018.
 */

interface IFoo<F>{

    F getFoo();
}

class MyTest{

    static List<String> foos = new ArrayList<>();

    public static <T> T getFoo(){
        return null;
    }

    public static void processIFoo(IFoo<String> ifs){
        foos.add(ifs.getFoo());
    }


}


public class FunctionalExpWithlambda {

    public static void main(String[] args) {

        MyTest.processIFoo( () -> {return new String();}  )  ;

        MyTest.processIFoo( () -> {return null; } )  ;

        MyTest.processIFoo( () -> new String()  )  ;

        MyTest.processIFoo( () ->  null )  ;

        MyTest.foos.add(MyTest.getFoo());
    }
}
