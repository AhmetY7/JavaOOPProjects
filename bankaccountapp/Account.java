package bankaccountapp;

public abstract class Account implements IBaseRate {
    // List common properties for saving and checking accounts
    private String name;
    private String sSN;
    private double balance;
    private static int index = 1000;

    protected String accountNumber; // private olursa bu class'ı extend edenler erişemez bu değişkene
    protected double rate;

    // Constructor to set base properties and initialize the account
    public Account(String name, String sSN, double initDeposit) {
        this.name = name;
        this.sSN = sSN;
        this.balance = initDeposit;

        // Set account number
        index++;
        this.accountNumber = setAccountNumber();
        setRate();
    }
    public abstract void setRate();

    private String setAccountNumber() {
        int uniqueID = index;
        int randomNumber = (int)(Math.random() * Math.pow(10,3));
        return sSN.substring(sSN.length()-2) + uniqueID + randomNumber;
    }
    public void compound() {
        double accuredParticipation = balance * (rate/100);
        balance += accuredParticipation;
        System.out.println("Accured Participation: $" + accuredParticipation);
        printBalance();
    }

    // List common methods - transactions
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Depositing $" + amount);
        printBalance();
    }

    public void withdraw(double amount) {
        balance -= amount;
        System.out.println("Withdrawing $" + amount);
        printBalance();
    }

    public void transfer(String toWhere, double amount) {
        balance -= amount;
        System.out.println("Transferring $" + amount + " to " + toWhere);
        printBalance();
    }

    public void printBalance() {
        System.out.println("Your balance is now: $" + balance);
    }

    public void showInfo() {
        System.out.println(
                "Name: " + name +
                "\nAccount Number: " + accountNumber +
                "\nBalance: " + balance +
                "\nParticipation Rate: " + rate + "%"
        );
    }
}
