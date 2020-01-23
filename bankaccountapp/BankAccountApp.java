package bankaccountapp;

import java.util.LinkedList;
import java.util.List;

public class BankAccountApp {
    public static void main(String[] args) {
        List<Account> accounts = new LinkedList<>();

        /*
        Checking chkacc1 = new Checking("Tom Wilson","256314568",1500);
        Savings savacc1 = new Savings("Rich Love","698521364",2500);
        savacc1.showInfo();
        System.out.println("********************************");
        chkacc1.showInfo();

        savacc1.deposit(5000);
        savacc1.withdraw(2000);
        savacc1.transfer("Mert", 1000);
        savacc1.compound();
         */

        // Read a CSV file then create new account based on that data
        String file = "C:\\Users\\ahmet\\Desktop\\Software\\Java\\JavaOOPProjects\\src\\bankaccountapp\\NewBankAccounts.csv";
        List<String[]> newAccountHolders = utilities.CSV.read(file);
        for(String[] accountHolder : newAccountHolders) {
            String name = accountHolder[0];
            String sSN = accountHolder[1];
            String accountType = accountHolder[2];
            double initDeposit = Double.parseDouble(accountHolder[3]);
            if(accountType.equals("Savings")) {
                accounts.add(new Savings(name, sSN, initDeposit));
            } else if(accountType.equals("Checking")) {
                accounts.add(new Checking(name, sSN, initDeposit));
            }
        }

        for(Account acc : accounts) {
            acc.showInfo();
            System.out.println("***************************************************************");
        }
    }
}
