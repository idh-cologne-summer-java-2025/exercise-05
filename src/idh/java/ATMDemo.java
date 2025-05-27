package idh.java;

public class ATMDemo {
    public static void main(String[] args) {
        Bank bank = new Bank();

        Account a1 = new Account(4000);
        a1.setPasscode("5093");
        bank.addAccount(a1);

        Account a2 = new Account(2000);
        a2.setPasscode("3905");
        bank.addAccount(a2);

        ATM atm = new ATM(bank);
        atm.run();
    }
}


