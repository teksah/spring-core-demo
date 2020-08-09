package com.javagda34.service;

import com.javagda34.model.Account;
import com.javagda34.repository.AccountDAO;
import org.springframework.stereotype.Service;

@Service
public class TransferServiceImpl implements TransferService {
    private final AccountDAO accountDAO;

    public TransferServiceImpl(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @Override
    public void deposit(double amount, Long toAccount) {
        final Account account = findAccountById(toAccount);
        account.setBalance(account.getBalance() + amount);

    }

    @Override
    public void withdraw(double amount, Long fromAccount) {
        final Account account = findAccountById(fromAccount);
        account.setBalance(account.getBalance() - amount);
    }

    @Override
    public void transfer(double amount, Long fromAccount, Long toAccount) {
        final Account from = findAccountById(fromAccount);
        final Account to = findAccountById(toAccount);
        from.setBalance(from.getBalance() - amount);
        to.setBalance(to.getBalance() + amount);
    }

    private Account findAccountById(Long toAccount) {
        return accountDAO.findById(toAccount).orElseThrow();
    }
}
