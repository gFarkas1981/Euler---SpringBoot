package com.gfarkas.euler.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class Divider {

    private Preparer preparer;
    private IsBigger isBigger;
    private Adder adder;
    private Subtractor subtractor;
    private Multiplicator multiplicator;

    private List<Integer> numberList1 = new ArrayList<>();
    private List<Integer> numberList2 = new ArrayList<>();
    private StringBuilder dividend = new StringBuilder();
    private StringBuilder divisor = new StringBuilder();

    @Autowired
    public void setPreparer(Preparer preparer) {
        this.preparer = preparer;
    }

    @Autowired
    public void setIsBigger(IsBigger isBigger) {
        this.isBigger = isBigger;
    }

    @Autowired
    public void setAdder(Adder adder) {
        this.adder = adder;
    }

    @Autowired
    public void setSubtractor(Subtractor subtractor) {
        this.subtractor = subtractor;
    }

    @Autowired
    public void setMultiplicator(Multiplicator multiplicator) {
        this.multiplicator = multiplicator;
    }

    public String divider(StringBuilder number1, StringBuilder number2) {

        boolean isNumber = true;



        try {   //if they are numbers

            for (int element : preparer.preparer(number1, number2).get(0)) {

                dividend.append(element);

            }

            for (int element : preparer.preparer(number1, number2).get(1)) {

                divisor.append(element);

            }


        } catch (IndexOutOfBoundsException nfe) {

            isNumber = false;   // one of them is not a number

        }

        String tempNumber = "1";

        if (isNumber) {

            // iterating through the first list

            while (isBigger.isBigger(dividend.toString(), divisor.toString()).equals("false")) {

                StringBuilder tempDivident = new StringBuilder();
                for (int i = dividend.length() - 1; i >= 0; i--) {

                    tempDivident.append(dividend.substring(i, i + 1));

                }

                while (isBigger.isBigger(multiplicator.multiplicator(divisor.toString(), tempNumber), dividend.toString()).equals("false") ||
                        isBigger.isBigger(multiplicator.multiplicator(divisor.toString(), tempNumber), dividend.toString()).equals("equal")) {
                    System.out.println("divisor: " + divisor);
                    System.out.println("product: " + multiplicator.multiplicator(divisor.toString(), tempNumber));
                    tempNumber = adder.adder(tempNumber, "1");

                }
                tempNumber = subtractor.subtractor(tempNumber, "1");


                System.out.println(tempDivident);

            }

            System.out.println("tempnumber: " + tempNumber);

        }

        return "";

    }
}

