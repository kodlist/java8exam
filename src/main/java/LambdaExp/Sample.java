package LambdaExp;

/**
 * Created by mkoduri on 9/23/2018.
 */

class A{
    char c;
    A(char c){ this.c  =c;}
}

class B extends A{
    char c = 'a';


    B() {
        super('b');
    }

    class C extends A
    {

        char c ='c';

        C()
        {
            super('d');
            System.out.println(B.this.c);
            System.out.println(C.this.c);
            System.out.println(super.c);
        }
    }
}
public class Sample {
}
