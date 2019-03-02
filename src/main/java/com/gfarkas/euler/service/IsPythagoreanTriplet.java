package com.gfarkas.euler.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IsPythagoreanTriplet {

    public boolean isPythagoreanTriplet(int a, int b, int c) {
        boolean isPythagoreanTriplet = false;
        if (a * a + b * b == c * c) {
            isPythagoreanTriplet = true;
        }
        return isPythagoreanTriplet;
    }
}
