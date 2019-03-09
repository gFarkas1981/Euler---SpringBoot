package com.gfarkas.euler.service;

import org.springframework.stereotype.Service;

@Service
public class StringReverser {

    /**
     * It reverses a string and
     * returns it in a StringBuilder
     */
    StringBuilder stringReverser(String inputString) {

        return new StringBuilder(new StringBuilder(inputString).reverse().toString());

    }

}
