import com.kata.exception.AccountException;
import com.kata.model.Account;
import com.kata.model.Operation;
import com.kata.model.Transaction;
import com.kata.service.AccountService;
import com.kata.service.IAccountService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class AccountServiceTest {

    IAccountService accountService = new AccountService();

    @Test
     void depositTest() {
        Account account = new Account(100);
        Transaction transaction = new Transaction(Operation.DEPOSIT, LocalDateTime.now(), 20d);
        accountService.deposit(account, transaction);
        Assertions.assertEquals(120d, account.getBalance());
    }

    @Test
     void withdrawTest() throws Exception {
        Account account = new Account(100);
        Transaction transaction = new Transaction(Operation.WITHDRAW, LocalDateTime.now(), 20d);
        accountService.withdraw(account, transaction);
        Assertions.assertEquals(80d, account.getBalance());
    }

    @Test
     void withdrawThrowExceptionTest(){
        Assertions.assertThrows(AccountException.class, () -> {
            Account account = new Account(100);
            Transaction transaction = new Transaction(Operation.WITHDRAW, LocalDateTime.now(), 120d);
            accountService.withdraw(account, transaction);
        });
    }
}
