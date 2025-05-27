package idh.java;

import java.util.HashMap;

public class Bank{
	
	// TODO: Use Map to enable a higher number of accounts 
	// and start nextAccountID with 7000001 
	
	HashMap<Integer, Account> accounts = new HashMap<>();
	

    // the next account ID to be used
    int nextAccountID = 7000001;
    
    /**
     * Adds an account to the bank.
     * @param account The account to add.
     */
    public void addAccount(Account account) {
        account.setId(nextAccountID++);
        accounts.put(account.getId(), account);
    }
    
    /**
     * Retrieves an account by its ID.
     * @param id The ID of the account.
     * @return The account with the given ID, or null if it doesn't exist.
     */
    public Account getAccount(int id) {
        return accounts.get(id);
    }
    
}