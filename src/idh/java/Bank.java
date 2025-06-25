package idh.java;
import java.util.HashMap;
import java.util.Map;


public class Bank{
	
	// TODO: Use Map to enable a higher number of accounts 
	// and start nextAccountID with 7000001
	Map<Integer, Account> accounts = new HashMap<Integer, Account>();
	
	
	Account[] accounts1 = new Account[5];
	int nextAccountID;

	public Bank() {
		nextAccountID = 7000001;
	}
	
	public boolean addAccount(Account account) {
		if(notYetFull()) {
			account.setId(nextAccountID);
			accounts.put(account.getId(), amount);
			System.out.println("Your account number is " + nextAccountID);
			
			nextAccountID++;
			
			return true;
		}
		else {
			return false;
		}
	}
	
	public Account getAccount(int number) {
		return accounts;
	}
	
	public boolean notYetFull() {
		return nextAccountID < accounts.length;
	}

}
