package com.gfarkas.euler.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FibonaccisUnder {

    List<Integer> fibonaccisUnder(int under) { //Puts Fibonacci numbers to Arraylist under input value
        List<Integer> fib = new ArrayList<>();
        int counter = 2;
        fib.add(1);
        fib.add(2);

        while (fib.get(counter - 1) < under) {
            fib.add(fib.get(counter - 2) + fib.get(counter - 1));
            counter++;
        }
        fib.remove(fib.size() - 1);
        return fib; //returns all the Fibonacci numbers under the input value.
    }

}
