package idh.java;

import java.util.Map;      // importin HashMap and Map utilities
import java.util.HashMap;

public class Bank {


	// Array replaced with HashMap
	Map<Integer, Account> accountsMap = new HashMap<>();
	int nextAccountID;


	public Bank() {
		nextAccountID = 7000001; //Starting accounts from 7000001
	}

	// Method changed to add Accounts to new Hashmap
	public boolean addAccount(Account account) {
			account.setId(nextAccountID);
			accountsMap.put(nextAccountID, account);
			System.out.println("Your account number is " + nextAccountID);

			nextAccountID++;
			return true;
		}


	//notYetFull Method removed, not needed anymore

	public Account getAccount(int number) {
		return accountsMap.get(number);
	}

}




