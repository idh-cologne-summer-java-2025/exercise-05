package idh.java;

import java.util.HashMap;
import java.util.Map;

public class Bank {

    // Aufgabe 1: Verwenden Sie Map, um eine höhere Anzahl von Konten zu ermöglichen
    // und starten Sie nextAccountID mit 7000001
    private Map<Integer, Account> accounts;
    private int nextAccountID;

    public Bank() {
        this.accounts = new HashMap<>();
        this.nextAccountID = 7000001; // Start-ID für Konten
    }

    /**
     * Fügt ein neues Konto zur Bank hinzu.
     * Die Kontonummer wird von der Bank automatisch vergeben.
     * Das übergebene Account-Objekt sollte bereits mit initialen Werten
     * (wie z.B. dem Passcode-Hash) initialisiert sein, bevor es hier hinzugefügt wird.
     *
     * @param account Das hinzuzufügende Konto-Objekt.
     * @return true, wenn das Konto erfolgreich hinzugefügt wurde, andernfalls false.
     */
    public boolean addAccount(Account account) {
        // Überprüfen, ob die nächste Account-ID bereits existiert (sollte nicht passieren bei korrekter Logik)
        if (accounts.containsKey(nextAccountID)) {
            System.err.println("Fehler: Konto-ID " + nextAccountID + " existiert bereits. Hinzufügen fehlgeschlagen.");
            return false;
        }

        // ID dem Konto zuweisen
        account.setId(nextAccountID);
        
        // Konto der HashMap hinzufügen
        accounts.put(nextAccountID, account);
        
        System.out.println("Konto erfolgreich erstellt. Ihre Kontonummer lautet: " + nextAccountID);
        
        // Nächste verfügbare Konto-ID inkrementieren
        nextAccountID++;
        
        return true;
    }

    /**
     * Ruft ein Konto anhand seiner Kontonummer ab.
     *
     * @param accountNumber Die Nummer des abzurufenden Kontos.
     * @return Das Account-Objekt, falls gefunden, andernfalls null.
     */
    public Account getAccount(int accountNumber) {
        return accounts.get(accountNumber);
    }

    // Die Methode notYetFull() wird nicht mehr benötigt, da HashMap dynamisch wächst.
}