package com.gfarkas.euler.service;

import org.springframework.stereotype.Service;

@Service
public class IsPerfectNumber {

    String isPerfectNumber(int number) {

        String isPerfectNumber = "";
        int sumOfProperDivisors = 0;

        for (int divisor = 1; divisor <= number  / 2; divisor++) {

            if (number % divisor == 0) {

                sumOfProperDivisors += divisor;

            }

        }

        if (sumOfProperDivisors == number) {
            isPerfectNumber = "perfect";
        } else if (sumOfProperDivisors < number) {
            isPerfectNumber = "deficient";
        } else {
            isPerfectNumber = "abundant";
        }


        return isPerfectNumber;
    }
}
