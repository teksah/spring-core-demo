package com.javagda34.repository;

import com.javagda34.model.Account;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Primary
public class AccountDAOImpl implements AccountDAO {

    @Override
    public List<Account> findAll() {
        return List.of(
                new Account(1L, 100d, "Jas", "Fasola"),
                new Account(2L, 80d, "Janek", "Smietanek"),
                new Account(3L, 70d, "Krzysiek", "Placek"),
                new Account(999L, 10_000_000d, "Jestem", "Bankiem")
        );
    }

    @Override
    public Optional<Account> findById(Long id) {
        return findAll().stream().filter(account -> account.getId().equals(id)).findFirst();
    }
}
