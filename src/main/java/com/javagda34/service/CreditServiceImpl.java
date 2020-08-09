package com.javagda34.service;

import org.springframework.stereotype.Service;

@Service
public class CreditServiceImpl implements CreditService {
    @Override
    public void takeCreditLoad(double amount) {
        System.out.println("Success. You have " + amount + "extra money!");
    }

    @Override
    public void takeMortgage(double amount) {
        System.out.println("Success. You have " + amount + "extra money!");
    }
}
