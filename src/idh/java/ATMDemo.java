package idh.java;

public class ATMDemo {

    public static void main(String[] args) {
        // ATM verwendet jetzt intern seine eigene Konten-Map
        ATM atm = new ATM();
        atm.run();
    }
}
