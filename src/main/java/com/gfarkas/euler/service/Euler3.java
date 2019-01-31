package com.gfarkas.euler.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Euler3 {

    private LargestPrimeFactor largestPrimeFactor;

    @Autowired
    public void setLargestPrimeFactor(LargestPrimeFactor largestPrimeFactor) {
        this.largestPrimeFactor = largestPrimeFactor;
    }

    public int euler3() {


        return largestPrimeFactor.largestPrimeFactor(600851475143L);

    }

}
