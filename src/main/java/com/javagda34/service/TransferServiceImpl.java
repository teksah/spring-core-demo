package com.javagda34.service;

import com.javagda34.model.Account;
import com.javagda34.repository.AccountDAO;
import com.javagda34.repository.AccountDAOImpl;
import org.springframework.stereotype.Service;

@Service
public class TransferServiceImpl implements TransferService {
    private final AccountDAO accountDAO = new AccountDAOImpl();

    @Override
    public void deposit(double amount, Account toAccount) {
        toAccount.setBalance(toAccount.getBalance() + amount);
    }

    @Override
    public void withdraw(double amount, Account fromAccount) {
        fromAccount.setBalance(fromAccount.getBalance() - amount);
    }

    @Override
    public void transfer(double amount, Account fromAccount, Account toAccount) {
        fromAccount.setBalance(fromAccount.getBalance() - amount);
        toAccount.setBalance(toAccount.getBalance() + amount);
    }
}
