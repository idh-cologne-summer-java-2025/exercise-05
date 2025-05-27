package idh.java;

import java.util.HashMap;
import java.util.Map;

public class Bank {

    private Map<Integer, Account> accounts = new HashMap<>();
    private int nextAccountID = 7000001;
    public boolean addAccount(Account account) {
        account.setId(nextAccountID);
        accounts.put(nextAccountID, account);

        System.out.println("Your account number is " + nextAccountID);

        nextAccountID++; 
        return true;
    }

    public Account getAccount(int number) {
        return accounts.get(number);
    }

    public boolean notYetFull() {
    	return true;
    }
}
