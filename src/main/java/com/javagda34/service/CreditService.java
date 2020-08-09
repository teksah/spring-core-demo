package com.javagda34.service;

import org.springframework.stereotype.Service;

public interface CreditService {
    void takeCreditLoad(double amount);

    void takeMortgage(double amount);
}
