package pl.pp;

public class Account {
    private String accountNumber;
    private double balance;
    private String ownerName;
    private String email;
    private String phoneNumber;

    // Constructor
    public Account(String accountNumber, double balance, String ownerName, String email, String phoneNumber) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.ownerName = ownerName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    // Getters
    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    // Setters
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit of PLN " + amount + " was made. New balance PLN " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Method to withdraw money
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew PLN " + amount + " from the account, Remaining balance = PLN " + balance);
        } else {
            System.out.println("Insufficient funds. You have PLN " + balance + " in your account.");
        }
    }
}
