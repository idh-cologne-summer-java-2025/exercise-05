package idh.java;

public class ATMDemo {

	public static void main(String[] args) {
		Bank bank = new Bank();

		Account a1 = new Account(5000);
		a1.setPasscode("1234");
		bank.addAccount(a1);

		Account a2 = new Account(5030);
		a2.setPasscode("2345");
		bank.addAccount(a2);

		Account a3 = new Account(7000);
		a3.setPasscode("3456");
		bank.addAccount(a3);

		ATM atm = new ATM(bank);
		atm.run();
	}
}
