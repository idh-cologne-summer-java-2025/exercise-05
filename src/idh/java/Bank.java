package idh.java;

import java.util.HashMap;
import java.util.Map;

public class Bank{
	Map<Integer,Account> accounts = new HashMap<Integer, Account>();
	int nextAccountID;

	public Bank() {
		nextAccountID = 7000001;
	}
	
	public boolean addAccount(Account account) {
			account.setId(nextAccountID); // setting the id of the account. This has to be done separately from put, as that only sets the id as the key. 
			accounts.put(account.getId(), account); // used account.getId() to make clear, that the ID of the account is the key. It´s the same as nextAccountId but has to be mentioned as the key.
			System.out.println("Your account number is " + nextAccountID);
			
			nextAccountID++;
			return true;
	}
	
	public Account getAccount(int number) { // number = key of the account (the id).
		return accounts.get(number);
	}
	
//	public boolean notYetFull() { // --> notYetFull() is not needed in the case of a HashMap, as it is never full and can always have additions to it.
//		return nextAccountID < accounts.length;
//	}

}
