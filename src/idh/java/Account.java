package idh.java;


/**
 * This class represents an account in our bank.
 * @author hermesj
 *
 */
public class Account {
	// the balance of the account
	int balance;
	
	// the id of the account
	int id;
	
	// Add passcode
	int passcodehash;

	public Account(int status) {
		// ID wird von der Bank vergeben!
		this.balance = status;
	}
	
	public void setPasscode(String passcode) {
		this.passcodehash = passcode.trim().hashCode();
	}
	
	/** Checks the passcode - and yes, hashes are crytographically not a very strong,
	 * there are better methods ;-)
	 * @param passcode
	 * @return
	 */
	public boolean login(String passcode) {
		return this.passcodehash==passcode.trim().hashCode();
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
	    if (sum > 0 && sum <= balance) { // Wird allerdings auch von der Bank überprüft, hier nochmal zur Sicherheit.
	        balance -= sum;
	    } else {
	        throw new IllegalArgumentException("Zuwenig Geld auf dem Konto!");
	    }
	}
	
	
}
