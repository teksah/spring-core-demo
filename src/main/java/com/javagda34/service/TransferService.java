package com.javagda34.service;

public interface TransferService {
    void deposit(double amount, Long toAccount);

    void withdraw(double amount, Long fromAccount);

    void transfer(double amount, Long fromAccount, Long toAccount);
}
