package idh.java;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
/**
 * This class represents an account in our bank.
 * @author reiterns
 *
 */
public class Account {
	int balance;
	int id;

	private String hashedPasscode;

	public Account(int status) {
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

	public void withdraw(int sum) {
		this.balance -= sum;
	}

	public void setPasscode(String passcode) {
		this.hashedPasscode = hash(passcode);
	}

	public boolean verifyPasscode(String input) {
		return hash(input).equals(hashedPasscode);
	}

	private String hash(String input) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			byte[] hashBytes = md.digest(input.getBytes());
			return Base64.getEncoder().encodeToString(hashBytes);
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("SHA-256 not available");
		}
	}
}