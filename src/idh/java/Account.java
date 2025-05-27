package idh.java;


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
	private int passcodeHash;
	//TODO: Add passcode

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
	
	public void setPasscode(int passcode) {
		this.passcodeHash = encode(passcode);
	}

	public boolean checkPasscode(int input) {
		return passcodeHash == encode(input);
	}

	private int encode(int passcode) {
		
		return (passcode * 31 + 7);
	}
}
