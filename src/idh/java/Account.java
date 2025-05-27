package idh.java;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class Account {
    private int balance;
    private int id;
    private byte[] hashedPasscode;

    public Account(int balance) {
        this.balance = balance;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void withdraw(int amount) {
        this.balance -= amount;
    }

    public void setPasscode(String passcode) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            hashedPasscode = md.digest(passcode.getBytes());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("SHA-256 not available");
        }
    }

    public boolean verifyPasscode(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] inputHash = md.digest(input.getBytes());
            return Arrays.equals(hashedPasscode, inputHash);
        } catch (NoSuchAlgorithmException e) {
            return false;
        }
    }
}
