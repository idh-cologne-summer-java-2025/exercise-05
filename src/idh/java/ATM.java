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
				System.out.print("Enter your passcode to verify: ");
				String accountPass = (br.readLine()); // read as String so we can get the hashcode of it.
				System.out.print("Enter the amount to withdraw: ");
				int amount = Integer.parseInt(br.readLine());
				cashout(accountNumber, amount, accountPass); // the reason why you only get an error at the end of a full dialog is because cashout only checks all of the conditions after the inputs. 
			} catch (Exception e) {
				e.printStackTrace();
				break;
			}
		}
	}

	public void cashout(int accountNumber, int amount, String accountPass) {
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
		
		// check passcode
		if (accountPass.hashCode() != account.getPassword()) { // hashcode != hashcode
			System.out.println("Sorry, wrong passcode.");
			return;
		}
		
		// check for balance of the account
		if (amount > account.getBalance()) {
			System.out.println("Sorry, you're out of money.");
			return;
		}
		
		
		// withdraw
		account.withdraw(amount);
		cash += amount;
		System.out.println("Ok, here is your money, enjoy!");

	}
	

}
