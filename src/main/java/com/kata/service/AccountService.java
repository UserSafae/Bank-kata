package com.kata.service;

import com.kata.exception.AccountException;
import com.kata.model.Account;
import com.kata.model.Transaction;


public class AccountService implements IAccountService {

    public void deposit(Account account, Transaction transaction) {
        account.setBalance(account.getBalance() + transaction.getAmount());
        transaction.setBalance(account.getBalance());
        account.getTransactions().add(transaction);
    }

    public void withdraw(Account account, Transaction transaction) throws AccountException {
        if (account.getBalance() < transaction.getAmount()) {
            throw AccountException.create("Withdraw refused");
        }
        account.setBalance(account.getBalance() - transaction.getAmount());
        transaction.setBalance(account.getBalance());
        account.getTransactions().add(transaction);
    }

    public void print(Account account) {
        account.getTransactions().forEach(t ->
                System.out.println("operation : "+ t.getType().name() +" date : "+ t.getDate() +" amount: "+ t.getAmount() +" balance : " + t.getBalance())
        );

    }
}
