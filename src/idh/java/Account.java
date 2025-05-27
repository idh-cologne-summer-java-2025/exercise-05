package idh.java;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class Account {
    private int balance;
    private int id;
    private byte[] passcodeHash;

    public Account(int balance, String passcode) {
        this.balance = balance;
        setPasscode(passcode);
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

    public void withdraw(int sum) {
        this.balance -= sum;
    }

    public void setPasscode(String passcode) {
        this.passcodeHash = hashPasscode(passcode);
    }

    public boolean verifyPasscode(String input) {
        return Arrays.equals(this.passcodeHash, hashPasscode(input));
    }

    private byte[] hashPasscode(String passcode) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            return digest.digest(passcode.getBytes());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("SHA-256 not available", e);
        }
    }
}
