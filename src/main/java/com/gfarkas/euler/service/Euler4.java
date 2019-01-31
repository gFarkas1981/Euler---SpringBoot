package com.gfarkas.euler.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class Euler4 {

    private IsPalindrome isPalindrome;
    @Autowired
    public void setIsPalindrome(IsPalindrome isPalindrome) {
        this.isPalindrome = isPalindrome;
    }

    public int euler4(int numberOfDigits){
        String maxFactorString = "9";
        String minFactorString = "1";
        while (maxFactorString.length() < numberOfDigits) maxFactorString = maxFactorString + "9";
        while (minFactorString.length() < numberOfDigits) minFactorString = minFactorString + "0";
        int maxFactor = Integer.valueOf(maxFactorString); //maxFactor with 3 digits is 999
        int minFactor = Integer.valueOf(minFactorString); //minFactor with 3 digits is 100
        int lpp = (int)(Math.pow(maxFactor,2)); //Largest Possible Pallindrome //with 3 digit factors is 999*999
        int spp = (int)(Math.pow(minFactor,2)); //Smallest Possible Pallindrome //with 3 digit factors is 100*100
        int lp = 0; //Largest Pallindrome
        for (int i = lpp;i > spp - 1; i--)
            if (isPalindrome.isPalindrome(i)) {
                for (int k = maxFactor; k >= minFactor; k--){
                    if (i % k == 0 && i / k > minFactor && i / k < maxFactor){
                        System.out.println(i + "GFHGFh" + i / k);
                        lp = i;
                        i = spp;
                        break;
                    }
                }
            }
        return lp;
    }



}
