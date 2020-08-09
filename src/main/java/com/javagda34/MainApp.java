package com.javagda34;

import com.javagda34.config.AppConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class MainApp {
    public static void main(String[] args) {

        final ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);

        System.out.println(Arrays.toString(context.getBeanDefinitionNames()));

    }

}
