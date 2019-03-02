package com.gfarkas.euler.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SumOfAnyTwoBigNumbers {

    public String sumOfAnyTwoBigNumbers(String number1, String number2) {

        StringBuilder reversedNumber1 = new StringBuilder(new StringBuilder(number1).reverse().toString());  // reverse a string
        StringBuilder reversedNumber2 = new StringBuilder(new StringBuilder(number2).reverse().toString());
        List<Integer> reversedNumberList1 = new ArrayList<>();
        List<Integer> reversedNumberList2 = new ArrayList<>();

        StringBuilder sumOfAnyTwoBigNumbers = new StringBuilder();

        if (reversedNumber1.length() > reversedNumber2.length()) {
            while (reversedNumber1.length() > reversedNumber2.length()) {
                reversedNumber2.append("0");
            }
        }else {
            while (reversedNumber2.length() > reversedNumber1.length()) {
                reversedNumber1.append("0");
            }
        }

        boolean isNumber = true;

        try {
            for (int i = 0; i < reversedNumber1.length(); i++) {
                reversedNumberList1.add(Integer.parseInt(reversedNumber1.substring(i, i + 1)));
            }

            for (int i = 0; i < reversedNumber2.length(); i++) {
                reversedNumberList2.add(Integer.parseInt(reversedNumber2.substring(i, i + 1)));
            }
        } catch (NumberFormatException nfe) {
            isNumber = false;
        }

        if (isNumber) {

            int remainder = 0;
            List<Integer> reversedResult = new ArrayList<>();

            for (int i = 0; i < reversedNumberList1.size(); i++) {
                reversedResult.add((reversedNumberList1.get(i) + reversedNumberList2.get(i) + remainder) % 10);
                remainder = (reversedNumberList1.get(i) + reversedNumberList2.get(i) + remainder) / 10;
            }
            reversedResult.add(remainder);

            for (int i = reversedResult.size() - 1; i >= 0; i--) {
                sumOfAnyTwoBigNumbers.append(reversedResult.get(i));
            }

            // removing leading zeros
            while (sumOfAnyTwoBigNumbers.substring(0, 1).equals("0")) {
                sumOfAnyTwoBigNumbers = new StringBuilder(sumOfAnyTwoBigNumbers.substring(1));
            }
        }
        return sumOfAnyTwoBigNumbers.toString();
    }

}
