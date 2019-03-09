package com.gfarkas.euler.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Preparer {

    private StringReverser stringReverser;
    private IntsToIntegerList intsToIntegerList;
    private AddZeros addZeros;

    @Autowired
    public void setStringReverser(StringReverser stringReverser) {
        this.stringReverser = stringReverser;
    }

    @Autowired
    public void setIntsToIntegerList(IntsToIntegerList intsToIntegerList) {
        this.intsToIntegerList = intsToIntegerList;
    }

    @Autowired
    public void setAddZeros(AddZeros addZeros) {
        this.addZeros = addZeros;
    }

    /**
     * It prepares two String format input numbers for calculation
     * Returns two integer lists in integer list
     */
    List<List<Integer>> preparer(String number1, String number2) {

        boolean areTheyNumbers = true;

        List<List<Integer>> listOfLists = new ArrayList<>();

        try {

            for (int i = 0; i < number1.length(); i++)
                Integer.parseInt(number1.substring(i, i + 1));

            for (int i = 0; i < number2.length(); i++)
                Integer.parseInt(number2.substring(i, i + 1));

        } catch (NumberFormatException nfe) {

            areTheyNumbers = false;  // at least one digit is not a number

        }

        if (areTheyNumbers) {

            StringBuilder reversedNumber1 = stringReverser.stringReverser(number1);
            StringBuilder reversedNumber2 = stringReverser.stringReverser(number2);

            reversedNumber1 = addZeros.addZeros(reversedNumber1, reversedNumber2);  // It adds zeros to string to be equal
            // to the other's size
            reversedNumber2 = addZeros.addZeros(reversedNumber2, reversedNumber1);  // e.g.: 123, 12 -> 123, 120

            List<Integer> reversedNumberList1 = new ArrayList<>();
            List<Integer> reversedNumberList2 = new ArrayList<>();

            reversedNumberList1 = intsToIntegerList.intsToIntegerList(reversedNumber1);

            reversedNumberList2 = intsToIntegerList.intsToIntegerList(reversedNumber2);


            listOfLists.add(reversedNumberList1);   // It adds two list to the output list
            listOfLists.add(reversedNumberList2);
            // first element is the first number, second is the second number

        }
        return listOfLists;
    }

}
