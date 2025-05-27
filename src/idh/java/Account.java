package idh.java;

import java.util.HashMap;
/**
 * This class represents an account in our bank.
 * @author reiterns
 *
 */
public class Account {
	
	
	// the balance of the account
	int balance;
	
	// the id of the account
	int id;
	
	//TODO: Add passcode
	int passcode;
	
	public void setPasscode(int passcode) {
		this.passcode = passcode;
	}
	public int getPasscode() {
		return passcode;
	}

	public Account(int status) {
		// ID wird von der Bank vergeben!
		this.balance = status;
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
	
	/**
	 * Withdraws a sum of money from the account
	 * @param sum
	 */
	public void withdraw(int sum) {
		this.balance = balance - sum;
	}
	
	
}
