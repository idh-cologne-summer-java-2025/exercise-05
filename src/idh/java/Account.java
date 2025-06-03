package idh.java;


/**
 * This class represents an account in our bank.
 * @author reiterns
 *
 */
public class Account {
	// the balance of the account
	int balance;
	
	private int passcodeHash;

	// the id of the account
	int id;
	

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
			this.passcodeHash = passcode.hashCode();
		}

		public boolean checkPasscode(String passcode) {
			return passcode.hashCode() == this.passcodeHash;
		}
	
	
}
