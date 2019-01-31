package com.gfarkas.euler.service;

import org.springframework.stereotype.Service;

@Service
public class ReverseNumber {

    public int reverseNumber(int number) {

        return Integer.parseInt(new StringBuilder(number + "").reverse().toString());
    }


}
