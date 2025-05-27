package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATM {
	int cash = 100000;
	Bank bank;

	public ATM(Bank bank) {
		this.bank = bank;
	}

	public void run() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			try {
				System.out.print("Enter your account number: ");
				int accountNumber = Integer.parseInt(br.readLine());

				System.out.print("Enter your 4-digit passcode: ");
				int passcode = Integer.parseInt(br.readLine());

				System.out.print("Enter the amount to withdraw: ");
				int amount = Integer.parseInt(br.readLine());

				cashout(accountNumber, passcode, amount);
			} catch (Exception e) {
				System.out.println("Invalid input. Exiting.");
				break;
			}
		}
	}

	public void cashout(int accountNumber, int passcode, int amount) {
		if (amount > cash) {
			System.out.println("Sorry, not enough cash left.");
			return;
		}

		Account account = bank.getAccount(accountNumber);
		if (account == null) {
			System.out.println("Sorry, this account doesn't exist.");
			return;
		}

		if (!account.checkPasscode(passcode)) {
			System.out.println("Incorrect passcode.");
			return;
		}

		if (amount > account.getBalance()) {
			System.out.println("Sorry, you're out of money.");
			return;
		}

		account.withdraw(amount);
		cash -= amount;
		System.out.println("Ok, here is your money, enjoy!");
	}
}