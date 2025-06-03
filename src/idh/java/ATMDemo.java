package idh.java;

import java.util.Scanner;

public class ATMDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

     //bank und atm
        Bank bank = new Bank();
        ATM atm = new ATM(bank);

        //konten
        int accB = bank.createAccount("Beyza", 1111);
        int accE = bank.createAccount("Emir", 2222);
        int accO = bank.createAccount("Ozan", 3333);
        int accD = bank.createAccount("Dj", 4444);
        

        System.out.println("Account-Zählung:"); //zum überprüfen von aufgabe 1
        System.out.println("Beyza Konto-Nr.: " + accB);
        System.out.println("Emir  Konto-Nr.: " + accE);
        System.out.println("Oezhan  Konto-Nr.: " + accO);
        System.out.println("Dj   Konto-Nr.: " + accD);

        //anfangsguthaben
        bank.getAccount(accB).deposit(10000);
        bank.getAccount(accE).deposit(10000);
        bank.getAccount(accO).deposit(10000);
        bank.getAccount(accD).deposit(10000);


        //kontoinhaber
        System.out.println("Wähle dein Konto:");
        System.out.println("1: Beyza\n2: Emir\n3: Oezhan\n4: Dj");
        int wahl = scanner.nextInt();

        int kontoNummer = -1;
        if (wahl == 1) kontoNummer = accB;
        else if (wahl == 2) kontoNummer = accE;
        else if (wahl == 3) kontoNummer = accO;
        else if (wahl == 4) kontoNummer = accD;
        else {
            System.out.println("Ungültige Auswahl.");
            return;
        }

        //pin
        System.out.print("Bitte PIN eingeben: ");
        int pin = scanner.nextInt();

        //betrag wählen
        System.out.print("Wieviel möchten Sie abheben? ");
        double betrag = scanner.nextDouble();

        boolean erfolg = atm.withdraw(kontoNummer, pin, betrag);
        if (erfolg) {
            System.out.println("Abhebung erfolgreich.");
        } else {
            System.out.println("Abhebung fehlgeschlagen, auszahlung nicht möglich.");
        }

        double kontostand = atm.getBalance(kontoNummer, pin);
        if (kontostand >= 0) {
            System.out.println("Kontostand: " + kontostand);
        } else {
            System.out.println("Zugriff auf Kontostand verweigert (falscher PIN).");
        }

        scanner.close();
    }
}

