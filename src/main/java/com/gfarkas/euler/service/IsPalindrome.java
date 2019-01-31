package com.gfarkas.euler.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IsPalindrome {

    private ReverseNumber reverseNumber;

    @Autowired
    public void setReverseNumber(ReverseNumber reverseNumber) {
        this.reverseNumber = reverseNumber;
    }

    public boolean isPalindrome(int number) {
        boolean isPalindrome = false;
        if (reverseNumber.reverseNumber(number) == number) isPalindrome = true;
        return isPalindrome;
    }


}
