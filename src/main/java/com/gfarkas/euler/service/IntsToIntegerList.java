package com.gfarkas.euler.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IntsToIntegerList {

    /**
     * Creates a List of integers from
     * input StringBuilder
     */
    List<Integer> intsToIntegerList(StringBuilder inputStringBuilder) {

        List<Integer> integerList = new ArrayList<>();

        for (int i = 0; i < inputStringBuilder.length(); i++) {     // iterating through input StringBuilder's digits
            // and adding them to an integer list
            integerList.add(Integer.parseInt(inputStringBuilder.substring(i, i + 1)));
        }

        return integerList;

    }

}
