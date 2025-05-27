package idh.java;

import java.util.HashMap;
import java.util.Map;

public class Bank{
	


	 Map <Integer, Account> counting = new HashMap <Integer, Account> ();
	 int nextAccountID;
		 

	public Bank() {
		nextAccountID = 1000007;
	}
	
	public boolean addAccount(Account account) {
			account.setId(nextAccountID);
			counting.put(account.getId(), account);
			System.out.println("Your account number is " + nextAccountID);
			
			nextAccountID++;
			return true;
		}
	
	
	public Account getAccount(int number) {
		return counting.get(number);
	}

}

