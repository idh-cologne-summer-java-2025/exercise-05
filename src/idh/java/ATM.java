package idh.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * ATM with 4-digit PIN check for each withdrawal.
 */
public class ATM {
    // Bargeldbestand im Automaten
    private int atmBalance = 10_000;

    // Konten-Verwaltung: Kontonummer → Account
    private Map<Integer, Account> accounts = new HashMap<>();

    public ATM() {
        // Beispielkonten anlegen (Kontostand, PIN)
        Account acc1 = new Account(17_000);
        acc1.setId(1);
        acc1.setPin("1234");
        accounts.put(acc1.getId(), acc1);

        Account acc2 = new Account(5_300);
        acc2.setId(2);
        acc2.setPin("2345");
        accounts.put(acc2.getId(), acc2);

        Account acc3 = new Account(107);
        acc3.setId(3);
        acc3.setPin("3456");
        accounts.put(acc3.getId(), acc3);
    }

    /**
     * Hauptschleife des Automaten:
     * Liest Kontonummer, Betrag und PIN ein.
     */
    public void run() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                System.out.print("Please, enter your account number: ");
                int accountNumber = Integer.parseInt(br.readLine().trim());

                if (!accounts.containsKey(accountNumber)) {
                    System.out.println("Sorry, account not found.");
                    continue;
                }

                System.out.print("Please, enter the amount to withdraw: ");
                int amount = Integer.parseInt(br.readLine().trim());

                System.out.print("Please, enter your 4-digit PIN: ");
                String pin = br.readLine().trim();

                cashout(accountNumber, amount, pin);
            } catch (IOException | NumberFormatException e) {
                System.out.println("Input error – exiting.");
                break;
            }
        }
    }

    /**
     * Führt die Auszahlung durch, wenn
     * - genug Geld im Automaten ist,
     * - das Konto existiert,
     * - der PIN korrekt ist,
     * - und das Konto ausreichend gedeckt ist.
     */
    public void cashout(int accountNumber, int amount, String pin) {
        Account account = accounts.get(accountNumber);

        // ATM-Kasse prüfen
        if (amount > atmBalance) {
            System.out.println("Sorry, not enough Ca$h in the ATM.");
            return;
        }

        // PIN und Kontostand prüfen
        try {
            account.withdraw(amount, pin);
        } catch (SecurityException se) {
            System.out.println("Sorry, wrong PIN.");
            return;
        } catch (IllegalArgumentException ia) {
            System.out.println("† Oh No! It seems you have insufficient funds †");
            return;
        }

        // Auszahlung und Aktualisierung
        atmBalance -= amount;
        System.out.println("Withdrawal approved, have a lovely day ♥♥♥");
    }

    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.run();
    }
}
