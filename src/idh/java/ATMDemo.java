package idh.java;

public class ATMDemo {

	public static void main(String[] args) {
		Bank bank = new Bank();
		
		Account a1 = new Account(5000);
		// TODO: a1.setPassword(...)
		bank.addAccount(a1);
		a1.setPasscode("1234");
		
		Account a2 = new Account(5030);
		// TODO: a2.setPassword(...)
		bank.addAccount(a2);
		a2.setPasscode("5678");
		
		Account a3 = new Account(5030);
		// TODO: a2.setPassword(...)
		bank.addAccount(a3);
		a3.setPasscode("4321");
		
		ATM atm = new ATM(bank);
		atm.run();
		
	}

}
