package com.javagda34.service;

import com.javagda34.model.Account;

public interface TransferService {
    void deposit(double amount, Account toAccount);

    void withdraw(double amount, Account fromAccount);

    void transfer(double amount, Account fromAccount, Account toAccount);
}
