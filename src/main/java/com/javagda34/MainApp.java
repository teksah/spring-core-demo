package com.javagda34;

import com.javagda34.config.AppConfiguration;
import com.javagda34.model.Account;
import com.javagda34.repository.AccountDAO;
import com.javagda34.repository.AccountDAOImpl;
import com.javagda34.service.TransferService;
import com.javagda34.service.TransferServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class MainApp {
    public static void main(String[] args) {

        final ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
        final AccountDAO accountDAO = context.getBean(AccountDAOImpl.class);
        final TransferService transferService = context.getBean(TransferServiceImpl.class);

        System.out.println("All accounts");
        accountDAO.findAll().forEach(System.out::println);

        System.out.println("");
        final Account jas = accountDAO.findById(1L).orElseThrow();
        final Account krzysiek = accountDAO.findById(3L).orElseThrow();

        transferService.deposit(150, jas);
        System.out.println(jas);

        transferService.withdraw(230, jas);
        System.out.println(jas);

        transferService.transfer(30, krzysiek, jas);
        System.out.println(krzysiek);
        System.out.println(jas);




        Arrays.stream(context.getBeanDefinitionNames())
                .forEach(System.out::println);

    }

}
