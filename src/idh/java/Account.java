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
	
	//TODO: Add passcode
	
	public int password; 
	// <-- 


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
	// NEU: Passwort setzen
    public void setPassword(int password) {
        this.password = password;
    }

    // NEU: Passwort prüfen
    public boolean checkPassword(int input) {
        return this.password == input;
    }
	
	
   
}
