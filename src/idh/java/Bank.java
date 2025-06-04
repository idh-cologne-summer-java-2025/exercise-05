package idh.java;

import java.util.HashMap;

public class Bank{
	
	// TODO: Use Map to enable a higher number of accounts 
	// and start nextAccountID with 7000001 
	HashMap<Integer, Account> accounts;
	
	int nextAccountID;

	public Bank() {
		accounts = new HashMap<Integer, Account>();
		nextAccountID = 7000000;
	}
	
	public boolean addAccount(Account account) {
		nextAccountID++;
		account.setId(nextAccountID);
		accounts.put(nextAccountID, account);
		return true;
	}
	
	public Account getAccount(int number) {
		return accounts.get(number);
	}


}
