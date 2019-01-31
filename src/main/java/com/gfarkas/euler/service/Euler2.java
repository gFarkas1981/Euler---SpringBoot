package com.gfarkas.euler.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Euler2 {

    private FibonaccisUnder fibonaccisUnder;

    @Autowired
    public void setFibonaccisUnder(FibonaccisUnder fibonaccisUnder) {
        this.fibonaccisUnder = fibonaccisUnder;
    }

    public int euler2() {

        int sum = 0; //initializing the sum of the even-valued terms
        List<Integer> fib = new ArrayList<>();
        fib = fibonaccisUnder.fibonaccisUnder(4000000); //Fibonaccis under 4million

        for (int i = 1; i < fib.size(); ) { //looping through Fibonaccis starting from the first pair number
            System.out.println(fib.get(i));
            sum = sum + fib.get(i);
            i = i + 3; // moving to the next pair number

        }
        return sum;
    }


}
