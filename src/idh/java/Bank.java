package idh.java;

import java.util.HashMap;
import java.util.Map;

public class Bank{
	
	Map<Integer, Account> bankAccounts = new HashMap<Integer, Account>();
	
	int nextAccountID;
	

	public Bank() {
		
		
		nextAccountID = 7000001;
	}
	
	public boolean addAccount(Account account) {
		account.setId(nextAccountID);
		bankAccounts.put (account.getId(), account);
		System.out.println("Your account number is " + nextAccountID);
		
		nextAccountID++;
		return true; 
	}
	
	public Account getAccount(int number) {
		return bankAccounts.get(number);
	}
	
//	public boolean notYetFull() {
//		return nextAccountID < bankAccounts.length;
//	}

}
