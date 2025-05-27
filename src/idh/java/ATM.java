package idh.java;


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM  {
	
	// initial cash in the ATM
	int cash = 100000;

	Bank bank;
	
	public ATM(Bank bank) {		
		this.bank = bank;
	}
	
	/**
	 * Main command loop of the ATM Asks the user to enter a number, and passes this
	 * number to the function cashout(...) which actually does the calculation and
	 * produces money. If the user enters anything else than an integer number, the
	 * loop breaks and the program exists
	 */
	public void run() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			try {
				System.out.print("Enter your account number: ");
				int accountNumber = Integer.parseInt(br.readLine());
				System.out.print("Enter the amount to withdraw: ");
				int amount = Integer.parseInt(br.readLine());
				cashout(accountNumber, amount);
			} catch (Exception e) {
				e.printStackTrace();
				break;
			}
		}
	}

	public void cashout(int accountNumber, int amount) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// check for cash in the ATM
		if (amount > cash) {
			System.out.println("Sorry, not enough cash left.");
			return;
		}
		
		// check for existence of the account
		Account account = bank.getAccount(accountNumber);
		if (account == null) {
			System.out.println("Sorry, this account doesn't exist.");
			return;
		}
		
		try {
			System.out.println("Bitte geben sie ihren Passcode ein: ");
			String passcode = br.readLine();
			
			if (!account.checkPasscode(passcode)) {
	            System.out.println("Falscher Passcode.");
	            return;
	        }
	    
		
		// TODO: Check passcode!
		
		// check for balance of the account
		if (amount > account.getBalance()) {
			System.out.println("Sorry, you're out of money.");
			return;
		}
		
		
		// withdraw
		if(account.withdraw(amount, passcode)) {
		cash -= amount;
		System.out.println("Ok, here is your money, enjoy!");

		}
	}
		catch (Exception e) {
			System.out.println("Systemfehler");
		}
}
}