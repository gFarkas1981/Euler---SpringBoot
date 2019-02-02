package com.gfarkas.euler.controller;

import com.gfarkas.euler.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;

@RestController
public class APIController {

    private String enterInteger = "Please, enter an integer number!";
    private Euler1 euler1;
    private Euler2 euler2;
    private Euler3 euler3;
    private Euler4 euler4;
    private LargestPrimeFactor largestPrimeFactor;
    private IsPrime isPrime;
    private IsPalindrome isPalindrome;
    private ReverseNumber reverseNumber;
    private FibonaccisUnder fibonaccisUnder;

    @Autowired
    public void setEuler1(Euler1 euler1) {
        this.euler1 = euler1;
    }

    @RequestMapping("/euler1")
    public String euler1() {
        return euler1.euler1();
    }

    @Autowired
    public void setEuler2(Euler2 euler2) {
        this.euler2 = euler2;
    }

    @RequestMapping("/euler2")
    public int euler2() {
        return euler2.euler2();
    }

    @Autowired
    public void setEuler3(Euler3 euler3) {
        this.euler3 = euler3;
    }

    @RequestMapping("/euler3")
    public int euler3() {
        return euler3.euler3();
    }

    @Autowired
    public void setEuler4(Euler4 euler4) {
        this.euler4 = euler4;
    }

    @Autowired
    public void setFibonaccisUnder(FibonaccisUnder fibonaccisUnder) {
        this.fibonaccisUnder = fibonaccisUnder;
    }


    @Autowired
    public void setLargestPrimeFactor(LargestPrimeFactor largestPrimeFactor) {
        this.largestPrimeFactor = largestPrimeFactor;
    }

    @RequestMapping("/euler4/{nrOfDigits}")
    public int euler4(@PathVariable("nrOfDigits") int nrOfDigits) {
        return euler4.euler4(nrOfDigits);
    }

    @RequestMapping("/lpf/{number}")
    public int lpf(@PathVariable("number") long number) {
        return largestPrimeFactor.largestPrimeFactor(number);
    }

    @Autowired
    public void setIsPrime(IsPrime isPrime) {
        this.isPrime = isPrime;
    }

    @RequestMapping("/isprime/{number}")
    public String isPrime(@PathVariable("number") int number) {
        String text = "";
        if (isPrime.isPrime(number)) {
            text = "Yes, " + number + " is a prime number!";
        } else {
            text = "No, " + number + " is not a prime number!";
        }
        return text;
    }

    @Autowired
    public void setIsPalindrome(IsPalindrome isPalindrome) {
        this.isPalindrome = isPalindrome;
    }

    @RequestMapping("/ispalindrome/{number}")
    public boolean isPalindrome(@PathVariable("number") int number) {
        return isPalindrome.isPalindrome(number);
    }

    @Autowired
    public void setReverseNumber(ReverseNumber reverseNumber) {
        this.reverseNumber = reverseNumber;
    }

    @RequestMapping("/reversenumber/{number}")
    public int reverseNumber(@PathVariable("number") int number) {
        return reverseNumber.reverseNumber(number);
    }


    @MessageMapping("/isPrime")
    @SendTo("/topic/responseField")
    private Greeting isPrime(HelloMessage message) throws Exception {
        String text = "";
        try {
            if (isPrime.isPrime(Integer.valueOf(HtmlUtils.htmlEscape(message.getName())))) {
                text = "Yes, " + Integer.valueOf(HtmlUtils.htmlEscape(message.getName())) + " is a prime number!";
            } else {
                text = "No, " + Integer.valueOf(HtmlUtils.htmlEscape(message.getName())) + " is not a prime number!";
            }
        } catch (Exception e) {
            return new Greeting(enterInteger);
        }
        return new Greeting(text);
    }

    @MessageMapping("/isPalindrome")
    @SendTo("/topic/responseField")
    private Greeting isPalindrome(HelloMessage message) throws Exception {
        String text = "";
        try {
            if (isPalindrome(Integer.valueOf(HtmlUtils.htmlEscape(message.getName())))) {
                text = "Yes, " + Integer.valueOf(HtmlUtils.htmlEscape(message.getName())) + " is a palindrome number!";
            } else {
                text = "No, " + Integer.valueOf(HtmlUtils.htmlEscape(message.getName())) + " is not a palindrome number!";
            }
        } catch (Exception e) {
            return new Greeting(enterInteger);
        }
        return new Greeting(text);
    }

    @MessageMapping("/fibonaccisUnder")
    @SendTo("/topic/responseField")
    private Greeting showFibonaccisUnder(HelloMessage message) throws Exception {
        try {
            return new Greeting(("Fibonacci numbers under your number are: " + fibonaccisUnder.fibonaccisUnder(Integer.valueOf(HtmlUtils.htmlEscape(message.getName())))).replace("[","").replace("]",""));
        } catch (Exception e) {
            return new Greeting(enterInteger);
        }
    }

    @MessageMapping("/reverseNumber")
    @SendTo("/topic/responseField")
    private Greeting reverseNumber(HelloMessage message) throws Exception {
        try {
            return new Greeting(("Your number in reverse order is: " + reverseNumber.reverseNumber(Integer.valueOf(HtmlUtils.htmlEscape(message.getName())))));
        } catch (Exception e) {
            return new Greeting(enterInteger);
        }
    }

    @MessageMapping("/largestPrimeFactor")
    @SendTo("/topic/responseField")
    private Greeting largestPrimeFactor(HelloMessage message) throws Exception {
        try {
            return new Greeting(("The largest prime factor of your number is: " + largestPrimeFactor.largestPrimeFactor(Integer.valueOf(HtmlUtils.htmlEscape(message.getName())))));
        } catch (Exception e) {
            return new Greeting(enterInteger);
        }
    }

}
