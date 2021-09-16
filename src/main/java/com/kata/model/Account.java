package com.kata.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Account {

    private String accountNumber;
    private double balance;
    private List<Transaction> transactions = new ArrayList<>();

    public Account(double balance) {
        this.balance = balance;
    }

}
