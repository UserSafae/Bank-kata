package com.kata.exception;

public class AccountException extends Exception {

    public AccountException(String message) {
        super(message);
    }

    public static AccountException create(String message) {
        return new AccountException(message);
    }
}
