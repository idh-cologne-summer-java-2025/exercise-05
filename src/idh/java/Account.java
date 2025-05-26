package idh.java;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

/**
 * This class represents an account in our bank.
 * Jetzt mit 4-stelligem PIN-Schutz.
 */
public class Account {
    private int balance;
    private int id;

    // PIN-Sicherheit
    private String pinHash;   // Base64-kodierter Hash
    private String salt;      // Base64-kodierter Salt

    private static final SecureRandom RNG = new SecureRandom();
    private static final String HASH_ALGO = "SHA-256";

    public Account(int initialBalance) {
        this.balance = initialBalance;
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

    /**
     * Setzt einen neuen 4-stelligen PIN.
     * @param pin genau 4 Ziffern
     */
    public void setPin(String pin) {
        if (pin == null || !pin.matches("\\d{4}")) {
            throw new IllegalArgumentException("PIN muss genau 4 Ziffern sein.");
        }
        byte[] saltBytes = new byte[16];
        RNG.nextBytes(saltBytes);
        this.salt = Base64.getEncoder().encodeToString(saltBytes);
        this.pinHash = hash(pin, saltBytes);
    }

    /**
     * Hebt einen Betrag ab, prüft vorher den PIN.
     * @param amount Betrag
     * @param pin Klartext-PIN
     */
    public void withdraw(int amount, String pin) {
        if (!verifyPin(pin)) {
            throw new SecurityException("Falscher PIN – Abhebung verweigert.");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("Unzureichendes Guthaben.");
        }
        balance -= amount;
    }

    // Hilfsmethode zur PIN-Überprüfung
    private boolean verifyPin(String pin) {
        if (pinHash == null || salt == null) {
            throw new IllegalStateException("PIN wurde noch nicht gesetzt.");
        }
        byte[] saltBytes = Base64.getDecoder().decode(salt);
        String attemptHash = hash(pin, saltBytes);
        return pinHash.equals(attemptHash);
    }

    // SHA-256-Hashing mit Salt, Ergebnis Base64
    private String hash(String pin, byte[] saltBytes) {
        try {
            MessageDigest md = MessageDigest.getInstance(HASH_ALGO);
            md.update(saltBytes);
            byte[] digest = md.digest(pin.getBytes());
            return Base64.getEncoder().encodeToString(digest);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Hash-Algorithmus nicht verfügbar", e);
        }
    }
}
