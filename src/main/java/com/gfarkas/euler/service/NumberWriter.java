package com.gfarkas.euler.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NumberWriter {

    private IntsToIntegerList intsToIntegerList;

    @Autowired
    public void setIntsToIntegerList(IntsToIntegerList intsToIntegerList) {
        this.intsToIntegerList = intsToIntegerList;
    }

    public String numberWriter (StringBuilder number) {

        List<Integer> digitsOfNumber = new ArrayList<>();
        digitsOfNumber = intsToIntegerList.intsToIntegerList(number);
        StringBuilder digits = new StringBuilder();
        int size = digitsOfNumber.size();

        for (int i = 0; i < size ; i++){

            if (size == 1 || (i == size - 1  && digitsOfNumber.get(size - 2) != 1) || (i == size - 3  || (i % 3 == 0) && i != size - 1 && size != 2)) {

                switch (digitsOfNumber.get(i)) {

                    case 1:

                        digits.append("one ");
                        break;

                    case 2:

                        digits.append("two ");
                        break;

                    case 3:

                        digits.append("three ");
                        break;

                    case 4:

                        digits.append("four ");
                        break;

                    case 5:

                        digits.append("five ");
                        break;

                    case 6:

                        digits.append("six ");
                        break;

                    case 7:

                        digits.append("seven ");
                        break;

                    case 8:

                        digits.append("eight ");
                        break;

                    case 9:

                        digits.append("nine ");
                        break;

                }
            }

            if (i == size - 2) {

                if (digitsOfNumber.get(i) == 1 && digitsOfNumber.get(size - 1) == 0)
                digits.append("ten");

                if (digitsOfNumber.get(i) == 1 && digitsOfNumber.get(size - 1) == 1)
                    digits.append("eleven");

                if (digitsOfNumber.get(i) == 1 && digitsOfNumber.get(size - 1) == 2)
                    digits.append("twelve");

                if (digitsOfNumber.get(i) == 1 && digitsOfNumber.get(size - 1) == 3)
                    digits.append("thirteen");

                if (digitsOfNumber.get(i) == 1 && digitsOfNumber.get(size - 1) == 4)
                    digits.append("fourteen");

                if (digitsOfNumber.get(i) == 1 && digitsOfNumber.get(size - 1) == 5)
                    digits.append("fifteen");

                if (digitsOfNumber.get(i) == 1 && digitsOfNumber.get(size - 1) == 6)
                    digits.append("sixteen");

                if (digitsOfNumber.get(i) == 1 && digitsOfNumber.get(size - 1) == 7)
                    digits.append("seventeen");

                if (digitsOfNumber.get(i) == 1 && digitsOfNumber.get(size - 1) == 8)
                    digits.append("eighteen");

                if (digitsOfNumber.get(i) == 1 && digitsOfNumber.get(size - 1) == 9)
                    digits.append("nineteen");

                if (digitsOfNumber.get(i) == 2)
                    digits.append("twenty ");

                if (digitsOfNumber.get(i) == 3)
                    digits.append("thirty ");

                if (digitsOfNumber.get(i) == 4)
                    digits.append("forty ");

                if (digitsOfNumber.get(i) == 5)
                    digits.append("fifty ");

                if (digitsOfNumber.get(i) == 6)
                    digits.append("sixty ");

                if (digitsOfNumber.get(i) == 7)
                    digits.append("seventy ");

                if (digitsOfNumber.get(i) == 8)
                    digits.append("eighty ");

                if (digitsOfNumber.get(i) == 9)
                    digits.append("ninety ");

            }

            if (i == size - 3) {



                if (digitsOfNumber.get(size - 2) == 0 && digitsOfNumber.get(size - 1) == 0 && digitsOfNumber.get(size - 3) != 0) {

                    digits.append("hundred ");

                } else {

                    if (digitsOfNumber.get(size - 3) != 0)
                        digits.append("hundred and ");

                }


            }

            if (i == size - 4) {

                digits.append("thousand ");

            }




        }

        String result = "";

        if (digitsOfNumber.size() != 0) {

            result = String.valueOf(digits);

        }

        return result;
    }
}
