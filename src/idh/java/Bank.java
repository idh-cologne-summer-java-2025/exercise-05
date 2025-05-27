package idh.java;

import java.util.HashMap;
import java.util.Map;

public class Bank{
	
	// TODO: Use Map to enable a higher number of accounts 
	// and start nextAccountID with 7000001 
	Map<Integer, Account> accounts = new HashMap<>();
	int nextAccountID = 70000001;

	public Bank() {
		nextAccountID = 0;
	}
	
	public boolean addAccount(Account account) {
		if(notYetFull()) {
			int accountId = nextAccountID;
			account.setId(accountId);
			accounts.put (accountId, account);
			System.out.println("Your account number is " + accountId);
			
			nextAccountID++;
			
			return true;
		}
		else {
			return false;
		}
	}
	
	public Account getAccount(int number) {
		return accounts.get(number);
	}
	
	public boolean notYetFull() {
		return true;
	}

}
