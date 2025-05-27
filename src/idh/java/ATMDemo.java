package idh.java;

public class ATMDemo {

	public static void main(String[] args) {
		Bank bank = new Bank();
		
		Account a1 = new Account(5000);
		setPassword(a2, 1234);
		bank.addAccount(a1);
		
		Account a2 = new Account(5030);
		setPassword(a2, 1235); 
		bank.addAccount(a2);
		
		Account a3 = new Account(5030);
		setPassword(a3, 1236);
		bank.addAccount(a3);
		
		ATM atm = new ATM(bank);
		atm.run();
		
	}

}
