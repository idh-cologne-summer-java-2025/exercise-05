package idh.java;

import java.util.HashMap;
import java.util.Map;

public class Bank{
	
	// TODO: Use Map to enable a higher number of accounts 
	// and start nextAccountID with 7000001 
//	Account[] accounts = new Account[5];
//	K,V for Maps need to be complex datatypes
	Map <Integer, Account>accounts = new HashMap<Integer, Account>(); //warum kann ich hier Account angeben?
	int nextAccountID;

	public Bank() {
		nextAccountID = 700001;
	}
	
	public boolean addAccount(Account account) {
		if(notYetFull()) {
			account.setId(nextAccountID);
//			accounts[nextAccountID]=account;
			accounts.put(account.getId(), account);
			System.out.println("Your account number is " + nextAccountID);
			
			nextAccountID++;
			
			return true;
		}
		else {
			return false;
		}
	}
	
//	returns account object matching the accountID
	public Account getAccount(Integer accountID) {
//		return accounts[number-1];
		return accounts.get(accountID);
	}
	
	public boolean notYetFull() {
		return nextAccountID < accounts.size();
	}

}
