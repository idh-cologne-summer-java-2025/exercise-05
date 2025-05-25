package idh.java;

// adding Jaava scurity classes for hash map
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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
	

	// added hashed passcode
	private String hashPasscode;

	private String hashPasscode(int passcode) {
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256"); // using Java.Security to ensure secure hashcode -> NOT using the stored int itself
			byte[] hashBytes = digest.digest(Integer.toString(passcode).getBytes()); //creating a byte array from the int
			StringBuilder hexString = new StringBuilder();
			for (byte b : hashBytes) { 										// loop through the byte array and convert each byte to a hex string
				hexString.append(String.format("%02x", 0xFF & b));
			}
			return hexString.toString();
		} catch (NoSuchAlgorithmException e) { 								// if the algorithm is not found
			throw new RuntimeException("Error while hashing passcode", e);
		}
	}
	// verifying passcode
	private boolean checkPasscode(int passcode) {
		String hashedPasscode = this.hashPasscode;
		return hashedPasscode.equals(hashPasscode(passcode));
	}



	public Account(int status, int passcode) {
		// ID wird von der Bank vergeben!
		this.balance = status;
		this.hashPasscode = hashPasscode(passcode);
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
	 * @param passcode passcode to check
	 */
	public boolean withdraw(int sum, int passcode) {
		if (checkPasscode(passcode)) {
			this.balance = balance - sum;
			return true;
		}
		return false;
	}
}
