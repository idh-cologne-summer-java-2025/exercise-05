package idh.java;

import java.util.Map;      // enable Map & HashMap types
import java.util.HashMap;

public class Bank{
	
	// Replace accountID array with HashMap for storing accountIDs
	Map<Integer, Account> accountsMap = new HashMap<>();
	int nextAccountID;

	public Bank() {
		nextAccountID = 7000001; // Start (bank internal) accountIDs at 7000001
	}
	
	public boolean addAccount(Account account) {
		account.setId(nextAccountID);
		accountsMap.put(nextAccountID, account);  // store accountID in hashMap
		System.out.println("Your account number is " + nextAccountID);
		nextAccountID++;
		return true;
	}
	
	public Account getAccount(int number) {
		return accountsMap.get(number); // returns accountID from hashMap
	}
	
}
