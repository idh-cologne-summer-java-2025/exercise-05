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
	
	private int hashedPasscode;
	
	public void setPasscode(String passcode) {
		this.hashedPasscode = passcode.hashCode();
	}
	
	public boolean checkPasscode(String inputPasscode) {
		return inputPasscode.hashCode() == this.hashedPasscode;
	}
	
	
	
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
	public boolean withdraw(int sum, String passcode) {
		if (!checkPasscode(passcode)) {
			System.out.println("Falscher Passcode");
				return false;
			} 
		if (sum > balance) {
			System.out.println("Kein Geld verfügbar");
		}
		
		balance -=sum;
		System.out.println("Abhebung erfolgreich");
		return true;
		//this.balance = balance - sum;
	}
	
	
	}
