package com.gfarkas.euler.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class Euler5 {

    public int euler5(){
        List<Integer> checkList = new ArrayList<Integer>();
        checkList.add(20);
        checkList.add(19);
        checkList.add(18);
        checkList.add(17);
        checkList.add(16);
        checkList.add(14);
        checkList.add(13);
        checkList.add(11);

        int divider = 0;
        int number = 40;
        while (divider < 8){
            for (Integer i : checkList){
                if (number % i == 0){
                    divider++;
                }else{
                    divider = 0;
                    number = number+20;
                }

            }

        }
        System.out.println(number);

        return number;
    }



}
