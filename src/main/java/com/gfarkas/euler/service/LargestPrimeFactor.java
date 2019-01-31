package com.gfarkas.euler.service;

import org.springframework.stereotype.Service;


@Service
public class LargestPrimeFactor {

    public int largestPrimeFactor(long number) {
        int i = 2;
        while (number > 1) {
            if (number % i == 0) {
                number /= i;
                i -= 1;
            }
            i += 1;
        }
        return i;
    }


}



