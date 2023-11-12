package org.example;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();

        String createAccountResponse1 = bank.createAccount("Макс", 20000.0);
        String createAccountResponse2 = bank.createAccount("Трия1", 20000.0);

        System.out.println(createAccountResponse1);
        System.out.println(createAccountResponse2);



        int accountNumber = 1;
        String findAccountResponse = bank.findAccount(accountNumber);
        System.out.println(findAccountResponse);

        accountNumber = 3;
        findAccountResponse = bank.findAccount(accountNumber);
        System.out.println(findAccountResponse);



        int fromAccountNumber = 1;
        int toAccountNumber = 2;
        double transferAmount = 200.0;

        String transferMoneyResponse = bank.transferMoney(fromAccountNumber, toAccountNumber, transferAmount);
        System.out.println(transferMoneyResponse);

        String findAccountResponse1 = bank.findAccount(1);
        String findAccountResponse2 = bank.findAccount(2);

        System.out.println(findAccountResponse1);
        System.out.println(findAccountResponse2);
    }
}
