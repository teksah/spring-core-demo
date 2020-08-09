package com.javagda34.service;

import com.javagda34.model.Account;

public interface TransferService {
    void deposit(double amount, Long toAccount);

    void withdraw(double amount, Long fromAccount);

    void transfer(double amount, Long fromAccount, Long toAccount);
}
