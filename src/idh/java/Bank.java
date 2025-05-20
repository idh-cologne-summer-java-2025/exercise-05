package idh.java;

public class Bank{
	
	// TODO: Use Map to enable a higher number of accounts 
	// and start nextAccountID with 7000001 
	Account[] accounts = new Account[5];
	int nextAccountID;

	public Bank() {
		nextAccountID = 0;
	}
	
	public boolean addAccount(Account account) {
		if(notYetFull()) {
			account.setId(nextAccountID);
			accounts[nextAccountID]=account;
			System.out.println("Your account number is " + nextAccountID);
			
			nextAccountID++;
			
			return true;
		}
		else {
			return false;
		}
	}
	
	public Account getAccount(int number) {
		return accounts[number-1];
	}
	
	public boolean notYetFull() {
		return nextAccountID < accounts.length;
	}

}
