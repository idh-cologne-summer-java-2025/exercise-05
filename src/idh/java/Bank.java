package idh.java;
import java.util.HashMap;

public class Bank {
    private HashMap<Integer, Account> accounts;
    private int nextAccountNumber = 7000001;

    public Bank() {
        accounts = new HashMap<>();
    }

    public int createAccount(String owner, int passcode) {
        int accountNumber = nextAccountNumber++;
        Account acc = new Account(accountNumber, owner, passcode);
        accounts.put(accountNumber, acc);
        return accountNumber;
    }

    public Account getAccount(int number) {
        return accounts.get(number);
    }
}
