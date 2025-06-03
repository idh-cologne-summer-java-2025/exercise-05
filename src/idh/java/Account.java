package idh.java;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class Account {
    private int number;
    private String owner;
    private double balance;
    private byte[] passcodeHash;

    public Account(int number, String owner, int passcode) {
        this.number = number;
        this.owner = owner;
        this.balance = 0;
        this.passcodeHash = hashPasscode(passcode);
    }

    private byte[] hashPasscode(int passcode) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            return md.digest(String.valueOf(passcode).getBytes());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean checkPasscode(int passcode) {
        return Arrays.equals(this.passcodeHash, hashPasscode(passcode));
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount, int passcode) {
        if (!checkPasscode(passcode)) return false;
        if (balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public double getBalance(int passcode) {
        if (!checkPasscode(passcode)) return -1;
        return balance;
    }

    public int getNumber() {
        return number;
    }

    public String getOwner() {
        return owner;
    }
}
