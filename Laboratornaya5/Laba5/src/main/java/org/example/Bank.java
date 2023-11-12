package org.example;
import java.util.ArrayList;
import java.util.List;

public class Bank {
    public String accountName;
    public double initialDeposit;
    public int accountNumber;
    private List<BankAccount> accounts;
    public Bank() {
        accounts = new ArrayList<>();
    }

    public String createAccount(String accountName, double initialDeposit) {
        if (initialDeposit < 0) {
            return "Від'ємна сума.";
        }

        try {
            String responseCreateAccount = null;

            accountNumber = numberGenerate();
            BankAccount bankAccount = new BankAccount(accountNumber, accountName, initialDeposit);
            accounts.add(bankAccount);

            responseCreateAccount = "Створено аккаунт. Номер: " + accountNumber + ". Назва: " + accountName + ". Стартовий баланс: " + initialDeposit + ".";

            return responseCreateAccount.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "Виникла помилка при створені аккаунту.";
        }
    }

    public String findAccount(int accountNumber) {
        try {
            String responseFindAccount = null;

            for (int i = 0; i < accounts.size(); i++) {
                BankAccount account = accounts.get(i);
                if (account.getAccountNumber() == accountNumber) {
                    int number = account.accountNumber;
                    String name = account.accountName;
                    double balance = account.balance;

                    responseFindAccount = "Знайдено аккаунт: " + number + ", " + name + ", " + balance + ".\n";
                }
            }
            if (responseFindAccount == null) {
                throw new AccountNotFoundException("Аккаунт не знайдено.");
            }

            return responseFindAccount.toString();

        } catch (AccountNotFoundException e) {
            return e.getMessage();
        }
    }

    public String transferMoney(int fromAccountNumber, int toAccountNumber, double amount) {
        BankAccount frst = null;
        BankAccount scnd = null;
        String responseTransferMoney = null;

        for (int i = 0; i < accounts.size(); i++) {
            BankAccount account = accounts.get(i);
            if (account.getAccountNumber() == fromAccountNumber) {
                frst = account;
            }
        }

        for (int j = 0; j < accounts.size(); j++) {
            BankAccount account = accounts.get(j);
            if (account.getAccountNumber() == toAccountNumber) {
                scnd = account;
            }
        }

        if (frst != null && scnd != null) {
            if (amount < 0) {
                return "Недостатньо коштів, щоб перевести їх.";
            }

            if (frst.balance >= amount) {
                frst.balance -= amount;
                scnd.balance += amount;
                responseTransferMoney = "Гроші успішно переказані.";
            } else {
                responseTransferMoney = "Недостатньо коштів на рахунку.";
            }
        }

        return responseTransferMoney;
    }

    private int numberGenerate() {
        return accounts.size() + 1;
    }
}