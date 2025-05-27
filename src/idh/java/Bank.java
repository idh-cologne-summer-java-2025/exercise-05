package idh.java;

import java.util.HashMap;
import java.util.Map;

public class Bank {

	private Map<Integer, Account> accounts = new HashMap<>();
	private int nextAccountID;

	public Bank() {
		nextAccountID = 7000001;
	}

	public boolean addAccount(Account account) {
		int accountId = nextAccountID;
		account.setId(accountId);
		accounts.put(accountId, account);
		System.out.println("Your account number is " + accountId);

		nextAccountID++;
		return true;
	}

	public Account getAccount(int number) {
		return accounts.get(number);
	}
}
