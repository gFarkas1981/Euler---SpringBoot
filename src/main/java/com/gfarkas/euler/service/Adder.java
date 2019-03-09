package com.gfarkas.euler.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 *  for example:
 *                   1259
 *                +  1212
 *                =  2471
 *  So, 2 plus 9 is 11. Remainder is 1.
 *  1 plus 5 plus remainder is 7. Remainder is 0.
 *  2 plus 2 is 4. Remainder is 0.
 *  1 plus 1 is 2. Remainder is 0.
 */



@Service
public class Adder {

    private Preparer preparer;
    private List<Integer> reversedNumberList1 = new ArrayList<>();
    private List<Integer> reversedNumberList2 = new ArrayList<>();

    @Autowired
    public void setPreparer(Preparer preparer) {
        this.preparer = preparer;
    }

    /**
     * It adds one input number (in String Format) to the other input number
     * It returns the sum of the two numbers (in String format)
     */
    public String adder (String number1, String number2) {

        StringBuilder sum = new StringBuilder();

        boolean isNumber = true;

        try {   //if they are numbers

            reversedNumberList1 = preparer.preparer(number1, number2).get(0);  //reversedNumberList1 = first list of list
            reversedNumberList2 = preparer.preparer(number1, number2).get(1);  //reversedNumberList2 = second list of list

        } catch (IndexOutOfBoundsException nfe) {

            isNumber = false;   // one of them is not a number

        }

        if (isNumber) {

            int remainder = 0;
            List<Integer> reversedResult = new ArrayList<>();
            // iterating through one of the list (they are the same size, the smaller filled with zeros)
            for (int i = 0; i < reversedNumberList1.size(); i++) {
                // We need to add the two actual digits + remainder. Digit = remainder of Result/10
                reversedResult.add((reversedNumberList1.get(i) + reversedNumberList2.get(i) + remainder) % 10);
                // The remainder which we need to store is result/10. It's casted to int so without remainder.
                remainder = (reversedNumberList1.get(i) + reversedNumberList2.get(i) + remainder) / 10;

            }

            reversedResult.add(remainder);  //adding the last remainder if any

            int sumOfDigits = 0;

            for (int i = reversedResult.size() - 1; i >= 0; i--) {

                sum.append(reversedResult.get(i));      // reverse back the result
                sumOfDigits += reversedResult.get(i);

            }

            if (sumOfDigits > 0) {

                // removing leading zeros
                while (sum.substring(0, 1).equals("0")) {
                    sum = new StringBuilder(sum.substring(1));
                }

            } else {
                sum.delete(0, sum.length());    // if sum of digits is 0 the result is 0.
                sum.append("0");
            }
        }


        return sum.toString();
    }
}


