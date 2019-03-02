package com.gfarkas.euler.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NrOfDivisors {

    private PrimeFactors primeFactors;

    @Autowired
    public void setPrimeFactors(PrimeFactors primeFactors) {
        this.primeFactors = primeFactors;
    }

    public int nrOfDivisors(int number) {  // we have a number for example: 600
        List<Integer> pf = primeFactors.primeFactors(number);  //putting into a list the prime factors of number: [2,2,2,3,5,5]
        List<Integer> powers = new ArrayList<>();  //a list for power of each prime factor
        int counter = 0;  // a counter to iterate through prime factors

        while (counter < pf.size() - 1) {  // while actual element is not the last element of the array
            if (pf.get(counter).equals(pf.get(counter + 1))) {  // if actual element equals to next element
                counter++;  //  increasing power
            } else {
                powers.add(counter + 1);  // adding power to the list of powers
                pf = pf.subList(counter + 1, pf.size());
                counter = 0;  // resetting counter
            }
        }
        powers.add(counter + 1);  // adding the last power      powers = [3,1,2]
        // nrOfDivisors of 600 = (3 + 1)(1 + 1)(2 + 1) = 24
        // 1, 2, 3, 4, 5, 6, 8, 10, 12, 15, 20, 24, 25 ,30, 40, 50, 60, 75, 100, 120, 150, 200, 300, 600
        counter = 0;  // reinitializing counter for another loop
        int nrOfDivisors = 1;  // initializing the number of divisors of input number
        while (counter < powers.size() - 1) {  // while actual element is not the last element of the array
            nrOfDivisors = nrOfDivisors * (powers.get(counter) + 1);    // we need to get the product of nrofdivisors
            // and actual element of powers - 1 eg. with the first element: 1 * (3 + 1) = 4, with the second element
            // 4 * (1 +  1) = 8
            counter++;  // moving to the next element
        }
        nrOfDivisors = nrOfDivisors * (powers.get(counter) + 1);  // and the last will be 8 * (2 + 1) = 24
        return nrOfDivisors;
    }
}
