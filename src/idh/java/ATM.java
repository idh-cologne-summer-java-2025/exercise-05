package idh.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ATM {
    int cash = 100000; // Bargeld im Automaten
    Bank bank;

    public ATM(Bank bank) {
        this.bank = bank;
    }

    public void run() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            try {
                System.out.print("Gib deine Kontonummer ein: ");
                int accountNumber = Integer.parseInt(br.readLine());

                System.out.print("Gib den Betrag ein, den du abheben möchtest: ");
                int amount = Integer.parseInt(br.readLine());

                cashout(accountNumber, amount);

            } catch (Exception e) {
                System.out.println("Ungültige Eingabe oder Fehler. Programm wird beendet.");
                break;
            }
        }
    }

    public void cashout(int accountNumber, int amount) {			// Auszahlfunktion
        if (amount > cash) {
            System.out.println("Leider nicht genug Bargeld im Automaten.");
            return;
        }

        Account account = bank.getAccount(accountNumber);
        if (account == null) {
            System.out.println("Dieses Konto gibt es nicht.");
            return;
        }

        System.out.print("Bitte gib deinen 4-stelligen Passcode ein: ");			// Passwortabfragefunktion
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputCode;
        try {
            inputCode = br.readLine();
        } catch (IOException e) {
            System.out.println("Fehler beim Lesen des Passcodes.");
            return;
        }

        if (!account.checkPasscode(inputCode)) {
            System.out.println("Falscher Passcode!");
            return;
        }

        if (amount > account.getBalance()) {
            System.out.println("Du hast nicht genug Geld auf deinem Konto.");
            return;
        }

        account.withdraw(amount);
        cash += amount;
        System.out.println("Hier ist dein Geld. Viel Spaß!");
    }
}
