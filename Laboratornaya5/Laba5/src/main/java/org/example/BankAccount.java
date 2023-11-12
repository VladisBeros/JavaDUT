package org.example;

public class BankAccount {
    public int accountNumber;
    public String accountName;
    public double balance;

    public BankAccount(int accountNumber, String accountName, double balance) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountSummary() {
        return "Номер аккаунту: " + accountNumber + ", I'мя аккаунту: " + accountName + ", Баланс: " + balance + "\n";
    }

    public String deposit(double amount) {
        balance += amount;
        return "Покладено: "+ amount + "\n";
    }

    public String withdraw(double amount) {
        balance -= amount;
        return "Знято: "+ amount + "\n";
    }
}