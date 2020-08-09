package com.javagda34;

import com.javagda34.config.AppConfiguration;
import com.javagda34.model.Account;
import com.javagda34.repository.AccountDAO;
import com.javagda34.service.CreditService;
import com.javagda34.service.TransferService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.Optional;

public class MainApp {

    private static ApplicationContext context;

    public static void main(String[] args) {

        context = new AnnotationConfigApplicationContext(AppConfiguration.class);

        final AccountDAO accountDAO = context.getBean(AccountDAO.class);
        final TransferService transferService = context.getBean(TransferService.class);
        final TransferService transferService1 = context.getBean(TransferService.class);
        final CreditService creditService = context.getBean(CreditService.class);

        System.out.println("All accounts");
        accountDAO.findAll().forEach(System.out::println);

        System.out.println("");

        transferService.deposit(150, 1L);
        System.out.println(getBeanById(1L));

        transferService.withdraw(230, 1L);
        System.out.println(getBeanById(1L));

        transferService.transfer(30, 3L, 1L);
        System.out.println(getBeanById(1L));
        System.out.println(getBeanById(3L));

        System.out.println("After loan");
        creditService.takeCreditLoad(1000d, 1L);
        System.out.println(getBeanById(1L));
        transferService1.transfer(105, 1L, 3L);
        System.out.println(getBeanById(3L));


        System.out.println();
        Arrays.stream(context.getBeanDefinitionNames())
                .forEach(System.out::println);

        final int numBeansOfType = getNumBeansOfType(TransferService.class);
        System.out.println(numBeansOfType);

    }

    private static Optional<Account> getBeanById(long l) {
        return context.getBean(AccountDAO.class).findById(l);
    }

    public static <T> int getNumBeansOfType(Class<T> type) {
        return context.getBeansOfType(TransferService.class).entrySet().size();
    }




}
