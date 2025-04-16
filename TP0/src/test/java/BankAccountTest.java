import org.example.BankAccount;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {
    @Test
    void depositShouldIncreaseBalance() {
        BankAccount account = new BankAccount(3000, 0.1);
        account.deposit(100);
        assertEquals(3100, account.getBalance());
    }

    @Test
    void depositNegativeAmountShouldThrowException() {
        BankAccount account = new BankAccount(3000, 0.05);
        assertThrows(IllegalArgumentException.class, () -> account.deposit(-50));
    }

    @Test
    void withdrawShouldDecreaseBalance() {
        BankAccount account = new BankAccount(100, 0.05);
        account.withdraw(30);
        assertEquals(70, account.getBalance());
    }

    @Test
    void withdrawMoreThanBalanceShouldThrowException() {
        BankAccount account = new BankAccount(100, 0.05);
        assertThrows(IllegalStateException.class, () -> account.withdraw(150));
    }

    @Test
    void transferShouldMoveMoneyBetweenAccounts() {
        BankAccount account1 = new BankAccount(100, 0.05);
        BankAccount account2 = new BankAccount(50, 0.05);
        account1.transfer(30, account2);

        assertEquals(70, account1.getBalance());
        assertEquals(80, account2.getBalance());
    }

    @Test
    void addInterestShouldIncreaseBalance() {
        BankAccount account = new BankAccount(100, 0.10);
        account.addInterest();
        assertEquals(110, account.getBalance());
    }
}