package idh.java;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    private Map<Integer, Account> accounts = new HashMap<>();
    private int nextAccountID;

    public Bank() {
        nextAccountID = 7000001;			// accounts starten bei 700001
    }

    public boolean addAccount(Account account) {		//Komto hinzufügen
        int accountID = nextAccountID;
        account.setId(accountID);
        accounts.put(accountID, account);
        System.out.println("Deine Kontonummer ist " + accountID);
        nextAccountID++;
        return true;			//keine begrenzung bei hashmap
    }

    public Account getAccount(int number) {		// account mit nummer suchen
        return accounts.get(number);
    }
}
