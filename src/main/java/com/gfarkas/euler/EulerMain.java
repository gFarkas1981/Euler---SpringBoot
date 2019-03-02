package com.gfarkas.euler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;


@SpringBootApplication
public class EulerMain {

    public static void main(String[] args) {
        ApplicationContext ct = SpringApplication.run(EulerMain.class, args);

        String[] beanArray = ct.getBeanDefinitionNames();
        Arrays.sort(beanArray);  //sorting bean names
        for (String name : beanArray) {
            System.out.println(name);
        }
    }
}

