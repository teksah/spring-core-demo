package com.javagda34.repository;

import com.javagda34.model.Account;

import java.util.List;
import java.util.Optional;

public interface AccountDAO {
    List<Account> findAll();
    Optional<Account> findById(Long id);
}
