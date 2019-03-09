package com.gfarkas.euler.service;

import org.springframework.stereotype.Service;


@Service
public class ZeroRemover {

    private String outputString;

    /**
     * Removes the leading zeros from input number (String format)
     * Returns a (String format) number without leading zeros
     */
    String zeroRemover(String inputString) {

        if (inputString.length() > 0 && !inputString.equals("0")) {

            while (inputString.substring(0, 1).equals("0")) {

                inputString = String.valueOf(new StringBuilder(inputString.substring(1)));

            }

        }

        return inputString;

    }

}
