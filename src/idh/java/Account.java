package idh.java;


/**
 * This class represents an account in our bank.
 */
public class Account {
    // the balance of the account
    private int balance;

    // the id of the account
    private int id;

    // the passcode for the account
    private String passcode;

    public Account(int balance, String passcode) {
        // ID wird von der Bank vergeben!
        this.balance = balance;
        this.passcode = passcode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getPasscode() {
        return passcode;
    }

    public void setPasscode(String passcode) {
        this.passcode = passcode;
    }

    /**
     * Withdraws a sum of money from the account.
     * @param sum the amount to withdraw
     */
    public void withdraw(int sum) {
        if (sum > 0 && sum <= balance) {
            this.balance -= sum;
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }
}
