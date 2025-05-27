package idh.java;

import java.util.HashMap;
import java.util.Map;

public class Bank{
	
	// TODO: Use Map to enable a higher number of accounts 
	// and start nextAccountID with 7000001 
	private Map<Integer, Account> accounts = new HashMap<>();
    private int nextAccountID;
	Account[] accounts = new Account[5];
	int nextAccountID;

	public Bank() {
		nextAccountID = 7000001;
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

}
