package idh.java;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    // Map für Konten: Account-ID → Account
    private Map<Integer, Account> accounts = new HashMap<>();
    // erste freie Kontonummer
    private int nextAccountID;

    public Bank() {
        // Kontonummern ab 7 000 001
        this.nextAccountID = 7_000_001;
    }

    /**
     * Legt ein neues Konto an, weist ihm eine eindeutige ID zu
     * und speichert es in der Map.
     * @param account das anzulegende Konto
     * @return immer true (keine Kapazitätsgrenze mehr)
     */
    public boolean addAccount(Account account) {
        int id = nextAccountID++;
        account.setId(id);
        accounts.put(id, account);
        System.out.println("Your account number is " + id);
        return true;
    }

    /**
     * Gibt das Konto zur übergebenen Kontonummer zurück,
     * oder null, falls es nicht existiert.
     * @param number die Kontonummer (ID)
     */
    public Account getAccount(int number) {
        return accounts.get(number);
    }
}
