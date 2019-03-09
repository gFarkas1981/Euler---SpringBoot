package com.gfarkas.euler.controller;


import com.gfarkas.euler.service.*;
import com.gfarkas.euler.service.DsignPDF.Dsign;
//import com.gfarkas.euler.service.ftp.FTPDownload;
//import com.gfarkas.euler.service.ftp.FTPUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;

import java.util.List;

@RestController
public class APIController {

    private String enterInteger = "Please, enter an integer number!";
    private Euler1 euler1;
    private Euler2 euler2;
    private Euler3 euler3;
    private Euler4 euler4;
    private Euler5 euler5;

    private LargestPrimeFactor largestPrimeFactor;
    private IsPrime isPrime;
    private IsPalindrome isPalindrome;
    private ReverseNumber reverseNumber;
    private FibonaccisUnder fibonaccisUnder;
    private PrimeFactors primeFactors;
    private NrOfDivisors nrOfDivisors;
    private Adder adder;
    private Subtractor subtractor;
    private IsBigger isBigger;
//    private FTPDownload ftpDownload;
//    private FTPUpload ftpUpload;
    private Dsign dsign;


    @Autowired
    public void setEuler1(Euler1 euler1) {
        this.euler1 = euler1;
    }

    @Autowired
    public void setEuler2(Euler2 euler2) {
        this.euler2 = euler2;
    }

    @Autowired
    public void setEuler3(Euler3 euler3) {
        this.euler3 = euler3;
    }

    @Autowired
    public void setEuler4(Euler4 euler4) {
        this.euler4 = euler4;
    }

    @Autowired
    public void setEuler5(Euler5 euler5) {
        this.euler5 = euler5;
    }


    @Autowired
    public void setNrOfDivisors(NrOfDivisors nrOfDivisors) {
        this.nrOfDivisors = nrOfDivisors;
    }

    @Autowired
    public void setIsPrime(IsPrime isPrime) {
        this.isPrime = isPrime;
    }

    @Autowired
    public void setIsPalindrome(IsPalindrome isPalindrome) {
        this.isPalindrome = isPalindrome;
    }

    @Autowired
    public void setReverseNumber(ReverseNumber reverseNumber) {
        this.reverseNumber = reverseNumber;
    }

    @Autowired
    public void setFibonaccisUnder(FibonaccisUnder fibonaccisUnder) {
        this.fibonaccisUnder = fibonaccisUnder;
    }

    @Autowired
    public void setLargestPrimeFactor(LargestPrimeFactor largestPrimeFactor) {
        this.largestPrimeFactor = largestPrimeFactor;
    }

    @Autowired
    public void setPrimeFactors(PrimeFactors primeFactors) {
        this.primeFactors = primeFactors;
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
    public void setIsBigger(IsBigger isBigger) {
        this.isBigger = isBigger;
    }

    //    @Autowired
//    public void setFtpUpload(FTPUpload ftpUpload) {
//        this.ftpUpload = ftpUpload;
//    }
//
//    @Autowired
//    public void setFtpDownload(FTPDownload ftpDownload) {
//        this.ftpDownload = ftpDownload;
//    }

    @Autowired
    public void setDsign(Dsign dsign) {
        this.dsign = dsign;
    }





    @RequestMapping("/euler1")
    public String euler1() {
        return euler1.euler1();
    }

    @RequestMapping("/euler2")
    public int euler2() {
        return euler2.euler2();
    }

    @RequestMapping("/euler3")
    public int euler3() {
        return euler3.euler3();
    }

    @RequestMapping("/euler4/{nrOfDigits}")
    public int euler4(@PathVariable("nrOfDigits") int nrOfDigits) {
        return euler4.euler4(nrOfDigits);
    }

    @RequestMapping("/euler5")
    public int euler5() {
        return euler5.euler5();
    }



//    @RequestMapping("/ftpdownload")
//    public void ftpdownload() {
//        ftpDownload.ftpDownload("pom.xml");
//    }

//    @RequestMapping("/ftpupload")
//    public void ftpupload() {
//        ftpUpload.ftpUpload();
//    }


    @RequestMapping("/dsign")
    public void dsign() throws Exception {
        dsign.dsign();
    }


    @RequestMapping("/sum/{number1}/{number2}")
    public String sum(@PathVariable("number1") String number1, @PathVariable("number2") String number2) {
        if (adder.adder(number1, number2).equals("")) {
            return "Please, enter integer numbers!";
        } else {
            return adder.adder(number1, number2);
        }
    }

    @RequestMapping("/subtract/{number1}/{number2}")
    public String subtract(@PathVariable("number1") String number1, @PathVariable("number2") String number2) {
        if (subtractor.subtractor(number1, number2).equals("")) {
            return "Please, enter integer numbers!";
        } else {
            return subtractor.subtractor(number1, number2);
        }
    }

    @RequestMapping("/isbigger/{number1}/{number2}")
    public String isBigger(@PathVariable("number1") String number1, @PathVariable("number2") String number2) {
        if (isBigger.isBigger(number1, number2).equals("")) {
            return "Please, enter integer numbers!";
        } else {
            return isBigger.isBigger(number1, number2);
        }
    }

    @RequestMapping("/lpf/{number}")
    public int lpf(@PathVariable("number") long number) {
        return largestPrimeFactor.largestPrimeFactor(number);
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

    @RequestMapping("/ispalindrome/{number}")
    public boolean isPalindrome(@PathVariable("number") int number) {
        return isPalindrome.isPalindrome(number);
    }

    @RequestMapping("/reversenumber/{number}")
    public int reverseNumber(@PathVariable("number") int number) {
        return reverseNumber.reverseNumber(number);
    }

    @RequestMapping("/primefactors/{number}")
    public List<Integer> primeFactors(@PathVariable("number") int number) {
        return primeFactors.primeFactors(number);
    }

    @RequestMapping("/nrofdivisors/{number}")
    public int nrOfDivisors(@PathVariable("number") int number) {
        return nrOfDivisors.nrOfDivisors(number);
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
            return new Greeting(("Fibonacci numbers under your number are: " + fibonaccisUnder.fibonaccisUnder(Integer.valueOf(HtmlUtils.htmlEscape(message.getName())))).replace("[", "").replace("]", ""));
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

    @MessageMapping("/euler1Button")
    @SendTo("/topic/responseField")
    private Greeting euler1(HelloMessage message) throws Exception {

        return new Greeting("Multiples of 3 and 5.<br><br>" +
                "Problem 1 <br>" +
                "If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23." +
                "<br>" +
                "Find the sum of all the multiples of 3 or 5 below 1000. <br><br>Result: " + euler1.euler1());

    }

    @MessageMapping("/euler2Button")
    @SendTo("/topic/responseField")
    private Greeting euler2(HelloMessage message) throws Exception {

        return new Greeting("Even Fibonacci numbers.<br><br>" +
                "Problem 2 <br>" +
                "Each new term in the Fibonacci sequence is generated by adding the previous two terms. By starting with 1 and 2, the first 10 terms will be:\n" +
                "\n" +
                "1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...\n" +
                "\n" +
                "By considering the terms in the Fibonacci sequence whose values do not exceed four million, find the sum of the even-valued terms. <br><br>Result: " + euler2.euler2());

    }

    @MessageMapping("/euler3Button")
    @SendTo("/topic/responseField")
    private Greeting euler3(HelloMessage message) throws Exception {

        return new Greeting("Largest prime factor<br><br>" +
                "Problem 3 <br>" +
                "The prime factors of 13195 are 5, 7, 13 and 29.\n" +
                "\n" +
                "What is the largest prime factor of the number 600851475143 ? <br><br>Result: " + euler3.euler3());

    }

    @MessageMapping("/euler4Button")
    @SendTo("/topic/responseField")

    private Greeting euler4(HelloMessage message) throws Exception {

        return new Greeting("Largest palindrome product<br><br>" +
                "Problem 4 <br>" +
                "A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.\n" +
                "\n" +
                "Find the largest palindrome made from the product of two 3-digit numbers. <br><br>Result: " + euler4.euler4(3));

    }

    @MessageMapping("/euler5Button")
    @SendTo("/topic/responseField")

    private Greeting euler5(HelloMessage message) throws Exception {

        return new Greeting("Smallest multiple<br><br>" +
                "Problem 5 <br>" +
                "2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.\n" +
                "\n" +
                "What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20? <br><br>Result: " + euler5.euler5());

    }

    @RestController
    public class MainController {
        @EventListener(ApplicationReadyEvent.class)
        public void doSomethingAfterStartup() throws Exception {
            System.out.println("I've just started up");
        }
    }
}
