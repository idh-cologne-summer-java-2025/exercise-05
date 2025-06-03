package idh.java;

public class ATM {
    private Bank bank;

    public ATM(Bank bank) {
        this.bank = bank;
    }

    public boolean withdraw(int accountNumber, int passcode, double amount) {
        Account acc = bank.getAccount(accountNumber);
        if (acc != null) {
            return acc.withdraw(amount, passcode);
        }
        return false;
    }

    public double getBalance(int accountNumber, int passcode) {
        Account acc = bank.getAccount(accountNumber);
        if (acc != null) {
            return acc.getBalance(passcode);
        }
        return -1;
    }
}
