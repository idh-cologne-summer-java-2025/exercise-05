package idh.java;

/**
 * This class represents an account in our bank.
 * @author reiterns
 *
 */

public class Account {
	int balance;
	int id;

	private int passcodeHash;

	public Account(int status, String passcode) {
		this.balance = status;
		this.passcodeHash = passcode.hashCode();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int status) {
		this.balance = status;
	}

	public void withdraw(int sum) {
		this.balance -= sum;
	}

	public boolean checkPasscode(String input) {
		return input.hashCode() == passcodeHash;
	}
}
