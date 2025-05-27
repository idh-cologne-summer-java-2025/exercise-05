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
        int accountID = nextAccountID++;
        account.setId(accountID);
        accounts.put(accountID, account);
        System.out.println("Your account number is " + accountID);
        return true;
    }

    public Account getAccount(int number) {
        return accounts.get(number);
    }
}
