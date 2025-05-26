package idh.java;
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
	
	String passcodeMD5;
	//TODO: Add passcode

	public Account(int status, String passcode) {
		// ID wird von der Bank vergeben!
		this.balance = status;
		setPassword(passcode);
		
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
	
	private  String md5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hashBytes = md.digest(input.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1)
                    hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private  boolean verifyMd5(String input, String expectedHash) {
        return md5(input).equalsIgnoreCase(expectedHash);
    }
    public void setPassword(String pW) {
    	this.passcodeMD5 = md5(pW);
    }
    
    public boolean checkpW(String pW) {
    	return verifyMd5(pW,this.passcodeMD5);
    }
	
	
}
