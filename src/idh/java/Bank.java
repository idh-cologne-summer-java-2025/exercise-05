package idh.java;

import java.util.HashMap;
import java.util.Map;

public class Bank{
	
	// Verwaltet alle Accounts mit Accounts mit Account-ID als Schlüssel
	private Map<Integer, Account> accounts = new HashMap<>();
	
	// Startet bei 700001
	
	private int nextAccountID = 7000001;
	
	
	// TODO: Use Map to enable a higher number of accounts 
	// and start nextAccountID with 7000001 
	//Account[] accounts = new Account[5];
	//int nextAccountID;

	public Bank() {
		//nextAccountID = 0;
	}
	
	public boolean addAccount(Account account) {
		//if(notYetFull()) {
			account.setId(nextAccountID);
			accounts.put(nextAccountID, account);
			System.out.println("Your account number is " + nextAccountID);
			
			nextAccountID++;
			
			return true;
		}
		//else {
			//return false;
		//}
	//}
	

	public Account getAccount(int number) {
		return accounts.get(number); //liefert null, wenn nicht vorhanden
				//[number-1];
	}
	
	//public boolean notYetFull() {
		//return nextAccountID < accounts.length;
	//}

}
