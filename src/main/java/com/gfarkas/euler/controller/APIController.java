package com.gfarkas.euler.controller;

import com.gfarkas.euler.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.HtmlUtils;

@RestController
public class APIController {

    private Euler1 euler1;
    private Euler2 euler2;
    private Euler3 euler3;
    private Euler4 euler4;
    private LargestPrimeFactor largestPrimeFactor;
    private IsPrime isPrime;
    private IsPalindrome isPalindrome;
    private ReverseNumber reverseNumber;

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


    @RequestMapping("/euler4/{nrOfDigits}")
    public int euler4(@PathVariable("nrOfDigits") int nrOfDigits) {
        return euler4.euler4(nrOfDigits);
    }

    @Autowired
    public void setLargestPrimeFactor(LargestPrimeFactor largestPrimeFactor) {
        this.largestPrimeFactor = largestPrimeFactor;
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
        return isPrime.isPrime(number);
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




    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    private Greeting greeting(HelloMessage message) throws Exception {
        return new Greeting("" + HtmlUtils.htmlEscape(message.getName()) + " is " + isPrime(Integer.valueOf(HtmlUtils.htmlEscape(message.getName()))));
    }




}
