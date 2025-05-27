package idh.java;

import java.util.HashMap;
import java.util.Map;

public class Bank {

	Map<Integer, Account> accounts = new HashMap<>();
	int nextAccountID;

	public Bank() {
		nextAccountID = 7000001; // Startwert korrekt gesetzt
	}

	public boolean addAccount(Account account) {
		account.setId(nextAccountID);
		accounts.put(nextAccountID, account);
		System.out.println("Your account number is " + nextAccountID);
		nextAccountID++;
		return true;
	}

	public Account getAccount(int number) {
		return accounts.get(number);
	}
}