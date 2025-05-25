package idh.java;

public class ATMDemo {

	public static void main(String[] args) {
		Bank bank = new Bank();
		
		Account a1 = new Account(5000);
		a1.setPassword(1234);
		bank.addAccount(a1);
		
		Account a2 = new Account(5030);
		// TODO: 
		a2.setPassword(5678);
		bank.addAccount(a2);
		
		Account a3 = new Account(5030);
		// TODO: 
		a3.setPassword(9012);
		bank.addAccount(a3);
		
		ATM atm = new ATM(bank);
		atm.run();
		
}

}
