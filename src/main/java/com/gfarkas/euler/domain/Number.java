package com.gfarkas.euler.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Number {

    @GeneratedValue
    @Id
    private Long id;
    private Long primes;
    private Long fibonaccis;

    public Number() {}

    public Long getPrimes() {
        return primes;
    }

    public void setPrimes(Long primes) {
        this.primes = primes;
    }

    public Long getFibonaccis() {
        return fibonaccis;
    }

    public void setFibonaccis(Long fibonaccis) {
        this.fibonaccis = fibonaccis;
    }
}
