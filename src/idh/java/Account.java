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
	
	//TODO: Add passcode
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
	
	public void setPasscode(String passcode) {
		if (passcode == null || !passcode.matches("\\d{4}")) {
			throw new IllegalArgumentException("Passcode must be 4 digits.");
		}
		this.passcodeHash = hashPasscode(passcode);
	}
	 public boolean checkPasscode(String passcode) {
		 return Arrays.equals(this.passcodeHash, hashPasscode(passcode));
		 
	 }
	 private byte[] hashPasscode(String passcode) {
			try {
				MessageDigest digest = MessageDigest.getInstance("SHA-256");
				return digest.digest(passcode.getBytes());
			} catch (NoSuchAlgorithmException e) {
				throw new RuntimeException("SHA-256 not available", e);
			}
		}
}
