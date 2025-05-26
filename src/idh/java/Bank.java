package idh.java;

import java.util.HashMap;
import java.util.Map;

public class Bank{
    
    // Using Map to enable a higher number of accounts
    private Map<Integer, Account> accounts = new HashMap<>();
    private int nextAccountID;

    public Bank() {
        nextAccountID = 7000001; // Start account numbers at 7000001
    }
    
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
    
    // This method is no longer needed with HashMap but kept for compatibility
    public boolean notYetFull() {
        return true;
    }
}
