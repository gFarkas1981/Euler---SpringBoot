package com.gfarkas.euler.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PrimeFactors {

        public List<Integer> primeFactors(int number) {
            List<Integer> factors = new ArrayList<>();
            for (int i = 2; i <= number / i; i++) {
                while (number % i == 0) {
                    factors.add(i);
                    number /= i;
                }
            }
            if (number > 1) {
                factors.add(number);
            }
            return factors;
        }
}
