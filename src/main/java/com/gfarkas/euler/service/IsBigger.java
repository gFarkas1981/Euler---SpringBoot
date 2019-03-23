package com.gfarkas.euler.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class IsBigger {

    private ZeroRemover zeroRemover;

    @Autowired
    public void setZeroRemover(ZeroRemover zeroRemover) {

        this.zeroRemover = zeroRemover;

    }

    /**
     * It determines if the first number (String format) is bigger then second one.
     * Returns "true" or "false" or "equal"
     */
    public String isBigger(String number1, String number2) {

        String isBigger = "";

        // removing leading zeros
        if (!number1.equals("0"))
            number1 = zeroRemover.zeroRemover(number1);

        if (!number2.equals("0"))
            number2 = zeroRemover.zeroRemover(number2);

        if (number1.equals(number2)) {  // if two String are the same

            isBigger = "equal"; // , they are equal

        } else {

            if (number1.length() > number2.length()) {  //  if first number is longer than the other,

                isBigger = "true";  // first number is bigger

            } else if (number1.length() < number2.length()) {   // else if second number is longer than the other,

                isBigger = "false"; // second number is bigger

            } else {    // two numbers with the same length

                while (!number1.equals("")) {

                    if (Integer.parseInt(number1.substring(0, 1)) > Integer.parseInt(number2.substring(0, 1))) {

                        isBigger = "true";  // true until all digits of first number is bigger or equal to second
                        break;

                    } else if (Integer.parseInt(number1.substring(0, 1)) < Integer.parseInt(number2.substring(0, 1))){

                        isBigger = "false"; // if only one digit is smaller then first number is smaller
                        break;

                    }
                    number1 = number1.substring(1);
                    number2 = number2.substring(1);

                }
            }
        }
        return isBigger;
    }

}
