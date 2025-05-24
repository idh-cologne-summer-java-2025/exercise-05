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
				if (checkAccount(accountNumber)) {
					System.out.print("Enter the amount to withdraw: ");
					int amount = Integer.parseInt(br.readLine());
					System.out.print("Enter your passcode: ");
					String passcode = (br.readLine());
					cashout(accountNumber, amount, passcode);
				}
			} catch (Exception e) {
				e.printStackTrace();
				break;
			}
		}
	}

	public void cashout(int accountNumber, int amount, String passcode) {
		// check for cash in the ATM
		Account account = bank.getAccount(accountNumber);
		if (amount > cash) {
			System.out.println("Sorry, not enough cash left.");
			return;
		}
		// TODO: Check passcode!
		//check if pincode is correct/does exist
		if (passcode.hashCode() != account.getPasscode()) {
			System.out.println("Sorry, wrong Passcode.");
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
	
	// check for existence of the account
	public boolean checkAccount (int accountNumber) {
			Account account = bank.getAccount(accountNumber);
			if (account == null) {
				System.out.println("Sorry, this account doesn't exist.");
				return false;
			}return true;
	}
}
