package Maps;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;

/**
 * Created by mkoduri on 8/29/2018.
 */

class Account{

    private String id;

    public Account(String id) {
        this.id = id;
    }


}
class BankAccount extends Account{

    private double balance;
    public BankAccount(String id, double balance) {
        super(id);
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }
}
public class ComputeMethodsInMap {

    public static void main(String[] args) {

        Map<String, Account> myacc = new HashMap<>();

        myacc.put("111", new Account("111"));
        myacc.put("222", new BankAccount("111", 220.0));

        BiFunction<String, Account, Account> bif =   (a1, a2)-> a2 instanceof BankAccount?new BankAccount(a1, 300.0):new Account(a1);

        myacc.computeIfPresent("222", bif);

        BankAccount ba = (BankAccount) myacc.get("222");

        System.out.println(ba.getBalance());






    }
}
