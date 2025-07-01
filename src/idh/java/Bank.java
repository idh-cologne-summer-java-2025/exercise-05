package idh.java;

import java.util.HashMap;
import java.util.Map;


public class Bank{
	
	// Use Map to enable a higher number of accounts 
	// and start nextAccountID with 7000001 

			Map<Integer, Account> accounts = new HashMap<Integer, Account>();
			int nextAccountID;
			
			public Bank() {
				nextAccountID = 7000001;
			}
			public boolean addAccount(Account account) {
				account.setId(nextAccountID);;
				accounts.put(account.getId(), account); //evtl. (nextAccountID, account, account) auch möglich?
				System.out.println("Account number:" + nextAccountID);
				
				nextAccountID++;
				return true;
			}	
	
			public Account getAccount(int number) {
				return accounts.get(number);
			}
}