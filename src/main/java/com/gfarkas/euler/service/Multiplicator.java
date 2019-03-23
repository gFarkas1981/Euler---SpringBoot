package com.gfarkas.euler.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class Multiplicator {

    private Preparer preparer;
    private Adder adder;

    private List<Integer> reversedNumberList1 = new ArrayList<>();
    private List<Integer> reversedNumberList2 = new ArrayList<>();

    @Autowired
    public void setPreparer(Preparer preparer) {
        this.preparer = preparer;
    }

    @Autowired
    public void setAdder(Adder adder) {
        this.adder = adder;
    }

    public String multiplicator(String number1, String number2) {

        String product = "";

        List<String> reversedResult = new ArrayList<>();

        boolean isNumber = true;

        try {   //if they are numbers

            reversedNumberList1 = preparer.preparer(number1, number2).get(0);  //reversedNumberList1 = first list of list
            reversedNumberList2 = preparer.preparer(number1, number2).get(1);  //reversedNumberList2 = second list of list

        } catch (IndexOutOfBoundsException nfe) {

            isNumber = false;   // one of them is not a number

        }

        if (isNumber) {


            for (int i = reversedNumberList2.size() - 1; i >= 0; i--) {



                for (int k = reversedNumberList1.size() - 1; k >= 0; k--) {

                    StringBuilder zeros = new StringBuilder();

                    if (k != 0 || i != 0) {

                        for (int z = 0; z < (k + i); z++) {

                            zeros.append("0");

                        }

                    }

                    product = adder.adder(product, reversedNumberList1.get(k) * reversedNumberList2.get(i) + "" + zeros);

                }
            }

        }

        return product;

    }
}




