package com.kata.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Transaction {

    private Operation type;
    private LocalDateTime date;
    private double amount;
    private double balance;

    public Transaction(Operation type, LocalDateTime date, Double amount) {
        this.type = type;
        this.date = date;
        this.amount = amount;
    }
}
