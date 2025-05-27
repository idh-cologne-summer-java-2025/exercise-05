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

				Account account = bank.getAccount(accountNumber);
				if (account == null) {
					System.out.println("Sorry, this account doesn't exist.");
					continue;
				}

				System.out.print("Enter your 4-digit passcode: ");
				String passcode = br.readLine();
				if (!account.verifyPasscode(passcode)) {
					System.out.println("Incorrect passcode!");
					continue;
				}

				System.out.print("Enter the amount to withdraw: ");
				int amount = Integer.parseInt(br.readLine());

				cashout(account, amount);
			} catch (Exception e) {
				e.printStackTrace();
				break;
			}
		}
	}

	public void cashout(Account account, int amount) {
		if (amount > cash) {
			System.out.println("Sorry, not enough cash left.");
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