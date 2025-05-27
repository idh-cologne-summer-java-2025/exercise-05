package idh.java;

public class Bank {
	private Account[] accounts = new Account[10];
	private int[] accountIds = new int[10]; // IDs getrennt gespeichert
	private int count = 0;
	private int nextAccountID = 7000001;

	public boolean addAccount(Account account) {
		if (count >= accounts.length) {
			System.out.println("Bank capacity reached.");
			return false;
		}
		account.setId(nextAccountID);
		accounts[count] = account;
		accountIds[count] = nextAccountID;
		System.out.println("Your account number is " + nextAccountID);
		nextAccountID++;
		count++;
		return true;
	}

	public Account getAccount(int number) {
		for (int i = 0; i < count; i++) {
			if (accountIds[i] == number) {
				return accounts[i];
			}
		}
		return null;
	}
}