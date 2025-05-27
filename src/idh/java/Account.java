package idh.java;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;


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
	
	private byte[] passcodeHash;

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
	
	public void setPassword(String passcode) {
		this.passcodeHash = hash(passcode);
	}
	
	public boolean checkPassword(String input) {
		return Arrays.equals(this.passcodeHash, hash(input));
	}
	
	private byte[] hash(String input) {
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			return digest.digest(input.getBytes());
		}	catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("SHA-256 algorithm not available");
		}
	}
}
