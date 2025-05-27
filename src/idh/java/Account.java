package idh.java;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Account {
    private int balance;
    private int id;
    private String hashedPasscode;

    public Account(int balance) {
        this.balance = balance;
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

    public void setHashedPasscode(String passcode) {
        this.hashedPasscode = hash(passcode);
    }

    public boolean verifyPasscode(String input) {
        return hash(input).equals(hashedPasscode);
    }

    private String hash(String passcode) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(passcode.getBytes());
            return Base64.getEncoder().encodeToString(hashBytes);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("SHA-256 not supported");
        }
    }
}