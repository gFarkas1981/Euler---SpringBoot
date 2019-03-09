package com.gfarkas.euler.service;

import org.springframework.stereotype.Service;

@Service
public class AddZeros {

    /**
     * It fills a shorter input StrigBuilder
     * to the length of a longer StringBuilder
     * It returns the ex-shorter StringBuilder filled
     * with zeros
     */
    StringBuilder addZeros(StringBuilder inputStringBuilderShorter, StringBuilder inputStringBuilderLonger) {

        while (inputStringBuilderShorter.length() < inputStringBuilderLonger.length()) {    // while first StringBuilder
            inputStringBuilderShorter.append("0");  // is shorter than the second one, it adds zeros to first
        }

        return inputStringBuilderShorter;

    }

}
