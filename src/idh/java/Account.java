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
	
	int passcodeHash; 
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
    public int getPassword() {

    return passcodeHash;
	
    }
	public int getBalance() {
		return balance;
	}

	public void setBalance(int status) {
		this.balance = status;
	}
	 public void setPassword(String passcode) {
	 this.passcodeHash = passcode.hashCode();
	 	 
	 }

	public void withdraw(int sum) {
		this.balance = balance - sum;
	}

	
	
}
