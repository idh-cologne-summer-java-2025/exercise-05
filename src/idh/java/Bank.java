package idh.java;

import java.util.HashMap;
import java.util.Map;

public class Bank {

    private Map<Integer, Account> accounts = new HashMap<>();
    private int nextAccountID;

    public Bank() {
        nextAccountID = 7000001;
    }

    public boolean addAccount(Account account) {
        int currentID = nextAccountID;
        account.setId(currentID);
        accounts.put(currentID, account);
        System.out.println("Demo account number " + (currentID - 7000000 ) + " is " + currentID);

        nextAccountID++;
        return true;
    }

    public Account getAccount(int number) {
        return accounts.get(number);
    }
}
