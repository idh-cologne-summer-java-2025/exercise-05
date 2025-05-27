package idh.java;

public class ATMDemo {
    public static void main(String[] args) {
        Bank bank = new Bank();

        // Beispielkonten anlegen
        bank.addAccount(new Account(5000, "1234"));
        bank.addAccount(new Account(2500, "abcd"));
        bank.addAccount(new Account(10000, "pass"));
				bank.addAccount(new Account(1000, "passtschon"));

        // ATM starten
        ATM atm = new ATM(bank);
        atm.run();
    }
}
