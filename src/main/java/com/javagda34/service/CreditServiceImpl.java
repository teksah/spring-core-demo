package com.javagda34.service;

import com.javagda34.model.Account;
import com.javagda34.repository.AccountDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class CreditServiceImpl implements CreditService {
    private final AccountDAO accountDAO;

    public CreditServiceImpl(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }


    @Override
    public void takeCreditLoad(double amount, Long applicant) {
        giveCredit(amount, applicant);
    }

    private void giveCredit(double amount, Long applicant) {
        final Account bank = accountDAO.findById(999L).orElseThrow();
        final Account account = accountDAO.findById(applicant).orElseThrow();
        calculate(amount, bank, account);
    }

    private void calculate(double amount, Account bank, Account account) {
        bank.setBalance(bank.getBalance() - amount);
        account.setBalance(account.getBalance() + amount);
    }


    public Account getBankAccount() {
        return accountDAO.findById(999L).orElseThrow();
    }
}
