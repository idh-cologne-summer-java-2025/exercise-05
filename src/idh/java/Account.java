package idh.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
	
	// the passcode of an account (hash of the String password)
	int passcode;

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
	
	// transform a String password to a hash (passcode)
	public void setPassword(String p) {
        if (p != null && p.length() == 4) {	
		passcode = p.hashCode();
			System.out.println("Converted password " + p + " to hash " + passcode);	
        } else {
			System.out.println("Invalid password. Password has to be 4 characters.");	    	
        }
	}
	
	// check the password entered corresponds to the account password (stored as a hash)
	public boolean checkPassword() {
		String p = "";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter your password: ");	
		try {
			p = br.readLine().toString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(p.hashCode() == passcode) {
			return true;
		} else {
			return false;
		}
	}
	
	public int getBalance() {
		return balance;
	}

	public void setBalance(int status) {
		this.balance = status;
	}
	
	/**
	 * Withdraws a sum of money from the account IF the account password was entered correctly
	 * @param sum
	 */
	public boolean withdraw(int sum) {
		if (checkPassword()) {
			this.balance = balance - sum;
			System.out.println("Ok, here is your money, enjoy!");
			return true;
		} else {
			System.out.println("Sorry. Incorrect password.");
			return false;
		}
	}
	
}
