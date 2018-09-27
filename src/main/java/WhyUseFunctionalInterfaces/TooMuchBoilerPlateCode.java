package WhyUseFunctionalInterfaces;

import java.util.function.Predicate;

/**
 * Created by mkoduri on 9/22/2018.
 */

interface AmountValidator {
    public boolean checkAmount(double value);

}

 class Account {

   /* public void updateBalance(double bal) {
        boolean isOK = new AmountValidator() {
            public boolean checkAmount(double val) {
                return val >= 0.0;
            }
        }.checkAmount(bal);
    }*/


     public void updateBalance(double bal ){
        Predicate<Double> p = val -> val>=0.0;
        //use lambda expression to create a Predicate and there is no need to create the AmountValidator interface and the anonymous class.
         boolean isOK = p.test(bal);
    }

}
public class TooMuchBoilerPlateCode {


    //There is no need to create the AmountValidator interface and the anonymous class.
    public static void main(String[] args) {

    }

}
