package idh.java;

public class ATMDemo {

    public static void main(String[] args) {
        Bank bank = new Bank();

        Account a1 = new Account(5000);
        bank.addAccount(a1, "1234");

        Account a2 = new Account(5030);
        bank.addAccount(a2, "5678");

        Account a3 = new Account(1000);
        bank.addAccount(a3, "9999");

        ATM atm = new ATM(bank);
        atm.run();
    }
}