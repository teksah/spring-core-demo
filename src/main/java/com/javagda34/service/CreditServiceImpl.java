package com.javagda34.service;

import com.javagda34.model.Account;
import com.javagda34.repository.AccountDAO;
import org.springframework.stereotype.Service;

@Service
public class CreditServiceImpl implements CreditService {
    private final AccountDAO accountDAO;

    public CreditServiceImpl(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }


    @Override
    public void takeCreditLoad(double amount, Account applicant) {
        final Account bank = getBankAccount();
        giveCredit(amount, applicant, bank);
    }

    private void giveCredit(double amount, Account applicant, Account bank) {
        bank.setBalance(bank.getBalance() - amount);
        applicant.setBalance(applicant.getBalance() + amount);
    }


    public Account getBankAccount() {
        return accountDAO.findById(999L).orElseThrow();
    }
}
