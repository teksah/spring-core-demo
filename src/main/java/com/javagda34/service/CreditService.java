package com.javagda34.service;

import com.javagda34.model.Account;
import org.springframework.stereotype.Service;

public interface CreditService {
    void takeCreditLoad(double amount, Account applicant);
}
