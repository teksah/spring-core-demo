package com.javagda34;

import com.javagda34.config.AppConfiguration;
import com.javagda34.repository.AccountDAOImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class MainApp {
    public static void main(String[] args) {

        final ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
        final AccountDAOImpl accountDAO = context.getBean(AccountDAOImpl.class);

        Arrays.stream(context.getBeanDefinitionNames())
                .forEach(System.out::println);

    }

}
