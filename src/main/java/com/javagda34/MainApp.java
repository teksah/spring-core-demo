package com.javagda34;

import com.javagda34.config.AppConfiguration;
import com.javagda34.model.Account;
import com.javagda34.repository.AccountDAO;
import com.javagda34.repository.AccountDAOImpl;
import com.javagda34.service.CreditService;
import com.javagda34.service.CreditServiceImpl;
import com.javagda34.service.TransferService;
import com.javagda34.service.TransferServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Arrays;
import java.util.Map;

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
        final Account jas = accountDAO.findById(1L).orElseThrow();
        final Account krzysiek = accountDAO.findById(3L).orElseThrow();

        transferService.deposit(150, jas);
        System.out.println(jas);

        transferService.withdraw(230, jas);
        System.out.println(jas);

        transferService.transfer(30, krzysiek, jas);
        System.out.println(krzysiek);
        System.out.println(jas);

        System.out.println("After loan");
        creditService.takeCreditLoad(1000d, jas);
        System.out.println(jas);
        transferService1.transfer(105, jas, krzysiek);
        System.out.println(krzysiek);


        System.out.println();
        Arrays.stream(context.getBeanDefinitionNames())
                .forEach(System.out::println);

        final int numBeansOfType = getNumBeansOfType(TransferService.class);
        System.out.println(numBeansOfType);

    }

    public static <T> int getNumBeansOfType(Class<T> type) {
        return context.getBeansOfType(TransferService.class).entrySet().size();
    }




}
