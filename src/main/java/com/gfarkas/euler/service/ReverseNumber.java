package com.gfarkas.euler.service;

import org.springframework.stereotype.Service;

@Service
public class ReverseNumber {

    public int reverseNumber(int number) {

        int lastDigit;
        int reversedNumber = 0;

        while (number > 0) {

            lastDigit = number % 10;
            number /= 10;
            reversedNumber = (reversedNumber * 10) + lastDigit;

        }

        return reversedNumber;
    }


}
