package idh.java;
import java.util.HashMap;
import java.util.Map;

public class Bank{
	
	// Eine HashMap erstellen
	 private Map<Integer, Account> accounts = new HashMap<>(); //Generics <Integer, Account>; Integer für Kontonummer also Key; Typ ist Account (ein Objekt der Account-Klasse
	 	
	 int nextAccountID = 7000001;
  

	public Bank() {
		//oder neue Konten hier initialisieren
	}
	
	// neues Konto hinzufügen
	public int addAccount(Account account) { //Typ der Methode ändern (boolean -> int)
			account.setId(nextAccountID);
			accounts.put(nextAccountID, account); //HashMap-Methode put benutzen anstatt addAccountID
			System.out.println("Your account number is " + nextAccountID);
			
			return nextAccountID++; //Rückgabewert der Methode (ein AccountID wird vergeben dann erhöhen sie sich alle bei der Bank um 1
	}
	
	//Konto anhand der ID finden
	public Account getAccount(int accountId) {
        return accounts.get(accountId);
    }
	
	
	public static void main(String[] args){
		Bank bank = new Bank();
		

        Account Account1 = new Account(500); 
        int id1 = bank.addAccount(Account1);

        

	}
}
