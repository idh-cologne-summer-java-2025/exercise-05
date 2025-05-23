package idh.java;


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM  {
	
	// initial cash in the ATM
	int cash = 100000;
	
	//wenn FailedLogin eine bestimmte Zahl erreicht, dann "zerstört" sich der Automat selbst
	int failedLogin = 0;
	
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
				System.out.print("Please enter Password: ");
				String password = br.readLine();
				System.out.print("Enter the amount to withdraw: ");
				int amount = Integer.parseInt(br.readLine());
				cashout(accountNumber, password, amount);
			} catch (Exception e) {
				e.printStackTrace();
				break;
			}
		}
	}

	public void cashout(int accountNumber, String password, int amount) {
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
		
		// Check passcode!
		if (password.hashCode() != account.passcode) {
			System.out.println("Password Incorrect!");
			failedLogin++;
			switch(failedLogin) {
				case 4:
					System.out.println("Self-Destruct Activated!");
					System.out.println("POW!!!!!!!!!!!!!!!!");
					System.exit(0);
				case 3:
					System.out.println("1 try remaining!");
					break;
				case 2:
					System.out.println("2 tries remaining!");
					break;
				case 1:
					System.out.println("3 tries remaining!");
					break;
			}
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
