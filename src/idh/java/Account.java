package idh.java;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

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
	
	//TODO: Add passcode
	private byte[] passcodeHash;
	
	public Account(int balance, String passcode) {
        this.balance = balance;
        this.passcodeHash = hashPasscode(passcode);
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

    /**
     * Withdraws a sum of money from the account, only if passcode is correct.
     * @param sum Betrag, der abgehoben werden soll
     * @param passcode Passcode als String
     * @return true wenn Abhebung erfolgreich, false sonst
     */
    public boolean withdraw(int sum, String passcode) {
        if (!checkPasscode(passcode)) {
            System.out.println("Invalid passcode!");
            return false;
        }
        if (sum > balance) {
            System.out.println("Insufficient funds!");
            return false;
        }
        balance -= sum;
        return true;
    }

    // ---- Hilfsmethoden zur Passcode-Hashing ----

    /**
     * Hasht den Passcode mit SHA-256.
     */
    private byte[] hashPasscode(String passcode) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            return digest.digest(passcode.getBytes(StandardCharsets.UTF_8));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("SHA-256 not supported", e);
        }
    }

    /**
     * Prüft, ob der eingegebene Passcode zum gespeicherten Hash passt.
     */
    private boolean checkPasscode(String passcode) {
        byte[] hash = hashPasscode(passcode);
        return Arrays.equals(hash, this.passcodeHash);
    }
}