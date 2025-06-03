package idh.java;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Account {
    int balance;
    int id;
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

    public void withdraw(int amount) {
        this.balance = balance - amount;
    }

    public void setPasscode(String passcode) {		// Passwort als Hash speichern (Sicherheit)
        hashedPasscode = hash(passcode);
    }

    public boolean checkPasscode(String input) {		// Passwort check
        if (hashedPasscode == null) {
            return false;
        }
        String inputHash = hash(input);
        return hashedPasscode.equals(inputHash);
    }

    private String hash(String input) {					//berechnet hash mit sha-256
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] bytes = md.digest(input.getBytes());				// wandelt text in byte array um
            String result = "";
            for (int i = 0; i < bytes.length; i++) {
                String hex = Integer.toHexString(bytes[i] & 0xff);		//wandelt byte array in hexadezimal string um und byte beinhaltet nur positive zahlen für erfolgreiche umwandlung
                if (hex.length() == 1) {
                    hex = "0" + hex;
                }
                result = result + hex;
            }
            return result;
        } catch (NoSuchAlgorithmException e) {
            System.out.println("SHA-256 Algorithmus nicht verfügbar");
            return null;
        }
    }
}
