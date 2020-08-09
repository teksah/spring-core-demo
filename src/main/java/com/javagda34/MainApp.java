package com.javagda34;

import com.javagda34.config.AppConfiguration;
import com.javagda34.model.Account;
import com.javagda34.repository.AccountDAO;
import com.javagda34.service.CreditService;
import com.javagda34.service.TransferService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Optional;

public class MainApp {

    private static ApplicationContext context;

    public static void main(String[] args) {

        context = new AnnotationConfigApplicationContext(AppConfiguration.class);

        final AccountDAO accountDAO = context.getBean(AccountDAO.class);
        final TransferService transferService = context.getBean(TransferService.class);
        final CreditService creditService = context.getBean(CreditService.class);

        System.out.println("All accounts");
        showAllAccounts(accountDAO);
        System.out.println();

        transferService.deposit(150, 1L);
        System.out.println(getAccountById(1L));

        transferService.withdraw(230, 1L);
        System.out.println(getAccountById(1L));

        transferService.transfer(30, 3L, 1L);
        System.out.println(getAccountById(1L));
        System.out.println(getAccountById(3L));

        System.out.println("After loan");
        creditService.takeCreditLoad(1000d, 1L);
        System.out.println(getAccountById(1L));
        transferService.transfer(105, 1L, 3L);
        System.out.println(getAccountById(3L));

        System.out.println(context.getBeanDefinitionCount());


    }

    private static void showAllAccounts(AccountDAO accountDAO) {
        accountDAO.findAll().forEach(System.out::println);
    }

    private static Optional<Account> getAccountById(long l) {
        return context.getBean(AccountDAO.class).findById(l);
    }

}
