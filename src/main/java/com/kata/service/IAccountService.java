package com.kata.service;

import com.kata.exception.AccountException;
import com.kata.model.Account;
import com.kata.model.Transaction;

public interface IAccountService {

    void deposit(Account account, Transaction transaction);
    void withdraw(Account account, Transaction transaction) throws AccountException;
    void print(Account account);

}
