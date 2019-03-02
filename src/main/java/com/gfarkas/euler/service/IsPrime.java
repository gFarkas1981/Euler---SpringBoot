package com.gfarkas.euler.service;

import org.springframework.stereotype.Service;

@Service
public class IsPrime {

    public boolean isPrime(int number) {
        boolean isPrime = false;
        int divider = 0;

        if (number < 20) {
            if (number == 2 || number == 3 || number == 5 || number == 7 || number == 11 ||
                number == 13 || number == 15 || number == 17 || number == 19) { //these are primes for sure
                isPrime = true;
            }

        } else {

            int examinedNumbers = (int) Math.sqrt(number);
            for (int x = 2; x < examinedNumbers + 1; x++) {
                if (number % x == 0) {
                    divider++;
                }
            }

            if (divider == 0) {
                isPrime = true;
            }
        }
        return isPrime;
    }
}
