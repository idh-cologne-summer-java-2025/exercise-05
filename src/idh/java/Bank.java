package idh.java;

import java.util.HashMap;

public class Bank{
	
	// TODO: Use Map to enable a higher number of accounts 
	// and start nextAccountID with 7000001 
	int nextAccountID;
	 HashMap<String , Account> hm1;
	
	public Bank() {
		nextAccountID = 7000001;
		hm1 = new HashMap<String , Account>();
	}
	
	public boolean addAccount(Account account) {
		if(notYetFull()) {
			account.setId(nextAccountID);
			String ID = Integer.toString(nextAccountID);
			  hm1.put(ID, account);
			System.out.println("Your account number is " + nextAccountID);
			
			nextAccountID++;
			
			return true;
		}
		else {
			return false;
		}
	}
	
	public Account getAccount(int number) {
		String AccNum = Integer.toString(number);
		return hm1.get(AccNum);
	}
	
	public boolean notYetFull() {
		return true;
	}

}
