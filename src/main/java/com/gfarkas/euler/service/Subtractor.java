package com.gfarkas.euler.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Subtractor {

    private IsBigger isBigger;
    private Preparer preparer;

    @Autowired
    public void setIsBigger(IsBigger isBigger) {
        this.isBigger = isBigger;
    }

    @Autowired
    public void setPreparer(Preparer preparer) {
        this.preparer = preparer;
    }

    private List<Integer> reversedNumberList1 = new ArrayList<>();
    private List<Integer> reversedNumberList2 = new ArrayList<>();

    /**
     *
     * for example:
     *               125
     *             - 019
     *             = 106
     *             So, to get 15 we need to add 6 to 9. remainder = 1.
     *             To get 2 we need to add 1 to 1 but we had 1 remainder. So it's 0. remainder = 0.
     *             To get 1 we need to add 1 to 0. We had no remainder and the remainder is 0.
     */
    public String subtractor(String number1, String number2) {

        String minus = "";

        StringBuilder result = new StringBuilder();

        String number1IsBigger = isBigger.isBigger(number1, number2);

        if (!number1IsBigger.equals("equal")) { // The two input numbers are not the same number

            boolean isNumber = true;

            try {   // trying if they are numbers

                reversedNumberList1 = preparer.preparer(number1, number2).get(0);  //reversedNumberList1 = first list of list
                reversedNumberList2 = preparer.preparer(number1, number2).get(1);  //reversedNumberList2 = second list of list

            } catch (IndexOutOfBoundsException nfe) {

                isNumber = false;   // at least one of them is not a number

            }

            if (isNumber) {

                int remainder = 0;
                List<Integer> reversedResult = new ArrayList<>();

                if (number1IsBigger.equals("false")) {  // second number is bigger

                    List<Integer> tempNumberList = new ArrayList<>(reversedNumberList1);    //changing the two numbers
                    reversedNumberList1 = new ArrayList<>(reversedNumberList2);
                    reversedNumberList2 = new ArrayList<>(tempNumberList);
                }

                for (int i = 0; i < reversedNumberList1.size(); i++) {  // iterating through the first number's digit
                    if (reversedNumberList1.get(i) < reversedNumberList2.get(i)) {  // 'upper' digit is bigger
                        // we need to add 10 to the upper number's digit, subtract lower number's digit and
                        //add the remainder if any
                        reversedResult.add(10 + reversedNumberList1.get(i) - (reversedNumberList2.get(i) + remainder));
                        remainder = 1;

                    } else {
                        // we need to subtract from upper number's digit the lower number's digit and
                        // add the remainder if any
                        reversedResult.add(reversedNumberList1.get(i) - (reversedNumberList2.get(i) + remainder));
                        remainder = 0;

                    }
                }

                for (int i = reversedResult.size() - 1; i >= 0; i--) {

                    result.append(reversedResult.get(i));     // reverse back the result

                }

                // removing leading zeros
                while (result.substring(0, 1).equals("0")) {

                    result  = new StringBuilder(result.substring(1));

                }

            }

            if (number1IsBigger.equals("false")) {

                minus = "-";    // If the first number is smaller we need to add a "-" char to the string

            }

        } else {    // The two input numbers are the same so there will be no difference. -> result = 0
            result.delete(0, result.length());
            result.append("0");
        }


        return minus + result.toString();

    }

}
