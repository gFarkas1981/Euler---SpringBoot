package com.gfarkas.euler.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Euler2 {
    public int euler2() {

        int sum = 0; //initializing the sum of the even-valued terms
        List<Integer> fib = new ArrayList<>();
        fib = fibonacci(4000000); //Fibonaccis under 4million

        for (int i = 1;i < fib.size();){ //looping through Fibonaccis starting from the first pair number
            System.out.println(fib.get(i));
            sum = sum + fib.get(i);
            i = i + 3; // moving to the next pair number

        }

        return sum;
    }

    private List<Integer> fibonacci(int under) { //Puts Fibonacci numbers to Arraylist under input value
        List<Integer> fib = new ArrayList<>();
        int counter = 2;
        fib.add(1);
        fib.add(2);

        while (fib.get(counter - 1) < under) {
            fib.add(fib.get(counter - 2) + fib.get(counter - 1));
            counter++;
        }
        fib.remove(fib.size()-1);
        return fib; //returns all the Fibonacci numbers under the input value.
    }

}
