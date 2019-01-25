package com.gfarkas.euler.service;

import org.springframework.stereotype.Service;

@Service
public class Euler1 {
    public String euler1(){
        int sum = 0;
        for (int i = 0; i < 1000; i++) {
            if (i % 3 == 0 || i % 5 == 0) //if actual value in loop divisible by 3 or 5
                sum += i;
        }
        return Integer.toString(sum); //returns the sum of all the multiples of 3 or 5 below 1000.
    }
}
