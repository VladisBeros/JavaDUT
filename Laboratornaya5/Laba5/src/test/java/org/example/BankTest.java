package org.example;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankTest {

    private Bank bank;

    @BeforeEach
    public void setUp() {
        bank = new Bank();
    }

    @Test
    public void testCreateAccount() {
        String response = bank.createAccount("Макс", 20000.0);
        assertEquals("Створено аккаунт. Номер: 1. Назва: Макс. Стартовий баланс: 20000.0.", response);
    }

    @Test
    public void testCreateAccountWithNegativeInitialDeposit() {
        String response = bank.createAccount("Олексiй", -100.0);
        assertEquals("Від'ємна сума.", response);
    }

    @Test
    public void testFindExistingAccount() {
        bank.createAccount("Алiна", 5000.0);
        String response = bank.findAccount(1);
        assertEquals("Знайдено аккаунт: 1, Алiна, 5000.0.\n", response);
    }

    @Test
    public void testFindNonExistingAccount() {
        String response = bank.findAccount(999);
        assertEquals("Аккаунт не знайдено.", response);
    }

    @Test
    public void testTransferMoney() {
        bank.createAccount("Трия1", 1000.0);
        bank.createAccount("Трия2", 500.0);

        String response = bank.transferMoney(1, 2, 200.0);
        assertEquals("Гроші успішно переказані.", response);
    }

    @Test
    public void testTransferMoneyWithInsufficientFunds() {
        bank.createAccount("Трия1", 100.0);
        bank.createAccount("Трия2", 500.0);

        String response = bank.transferMoney(1, 2, 200.0);
        assertEquals("Недостатньо коштів на рахунку.", response);
    }

    @Test
    public void testTransferMoneyWithNegativeAmount() {
        bank.createAccount("Трия1", 100.0);
        bank.createAccount("Трия2", 500.0);

        String response = bank.transferMoney(1, 2, -50.0);
        assertEquals("Недостатньо коштів, щоб перевести їх.", response);
    }
}