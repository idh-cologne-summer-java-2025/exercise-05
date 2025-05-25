package idh.java;

public class ATMDemo {

	public static void main(String[] args) {
		Bank bank = new Bank();
		
		Account a1 = new Account(5000, 1234);
		// TODO: a1.setPassword(...)
		bank.addAccount(a1);
		
		Account a2 = new Account(5030, 1337);
		// TODO: a2.setPassword(...)
		bank.addAccount(a2);
		
		Account a3 = new Account(5030, 7353);
		// TODO: a2.setPassword(...)
		bank.addAccount(a3);
		
		ATM atm = new ATM(bank);
		atm.run();
		
	}

}
