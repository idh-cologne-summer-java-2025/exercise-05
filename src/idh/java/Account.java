package idh.java;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.nio.charset.StandardCharsets;

/**
 * This class represents an account in our bank.
 * @author reiterns
 *
 */
public class Account {
    // the balance of the account
    int balance;
    
    // the id of the account
    int id;
    
    // Secure storage for passcode (hashed)
    private String passcodeHash;

    public Account(int status) {
        // ID wird von der Bank vergeben!
        this.balance = status;
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

    public void setBalance(int status) {
        this.balance = status;
    }
    
    /**
     * Withdraws a sum of money from the account
     * @param sum
     */
    public void withdraw(int sum) {
        this.balance = balance - sum;
    }
    
    /**
     * Sets a 4-digit passcode for the account
     * @param passcode The passcode to set
     */
    public void setPasscode(int passcode) {
        // Validate that it's a 4-digit number
        if (passcode < 1000 || passcode > 9999) {
            throw new IllegalArgumentException("Passcode must be a 4-digit number");
        }
        
        // Store the hashed passcode
        this.passcodeHash = hashPasscode(passcode);
    }
    
    /**
     * Verifies if the provided passcode matches the stored one
     * @param passcode The passcode to verify
     * @return true if passcode is correct, false otherwise
     */
    public boolean verifyPasscode(int passcode) {
        if (passcodeHash == null) {
            return false;
        }
        return passcodeHash.equals(hashPasscode(passcode));
    }
    
    /**
     * Creates a secure hash of the passcode
     * @param passcode The passcode to hash
     * @return A string representation of the hash
     */
    private String hashPasscode(int passcode) {
        try {
            // Add account ID as salt to make hash more secure and a String
            String passcodeWithSalt = String.valueOf(passcode) + "-salt-" + id;
            
            // hash the salty passcode using SHA-256
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(passcodeWithSalt.getBytes(StandardCharsets.UTF_8));
            
            // Convert to hex string
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Failed to hash passcode", e);
        }
    }
}
