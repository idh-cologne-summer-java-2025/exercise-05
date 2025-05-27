package idh.java;


/**
 * This class represents an account in our bank.
 * @author reiterns
 *
 */
public class Account {
	// the balance of the account
	int balance;
	
	public Integer getPassword() {
		return passcode;
	}

//	public void setPassword(Integer password) {
//		this.password = password;
//	}

	// the id of the account
	int id;
	
	//TODO: Add passcode, change to String
	private String passcode = "700001";

	public Account(int status) {
		// ID wird von der Bank vergeben!
		this.balance = status;
//		this.passcode = passcode.hashCode(); //moved to setPasscode
		this.setPasscode();
		passcode.valueOf(passcode);
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
	
	public Integer getPasscode() {
		return passcode.hashCode();
	}
//	HashFunction to encode passcode (Not collision-safe, should change to SHA-256)
	public void setPasscode() {
		this.passcode = passcode.hashCode();
	}

	/**
	 * Withdraws a sum of money from the account
	 * @param sum
	 */
	public void withdraw(int sum) {
		this.balance = balance - sum;
	}
	
	
}
