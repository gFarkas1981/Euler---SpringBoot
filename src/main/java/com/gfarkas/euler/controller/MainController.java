package com.gfarkas.euler.controller;

import com.gfarkas.euler.domain.Number;
import com.gfarkas.euler.repository.NumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
public class MainController {

    @Autowired
    NumberRepository numberRepository;

    public NumberRepository getNumberRepository() {
        return numberRepository;
    }

    public void setNumberRepository(NumberRepository numberRepository) {
        this.numberRepository = numberRepository;
    }

    @RequestMapping("/")
    public String viewHome(Model model) {
        model.addAttribute("name", (int) (Math.random() * 10000));
        return "index";
    }

    private List<Number> getNumbers() {
        ArrayList<Number> numbers = new ArrayList<>();
//        List<Number> numbers = numberRepository.findAll();

        Number number1 = new Number();
        number1.setFibonaccis(1L);
        number1.setFibonaccis(2L);
        number1.setFibonaccis(3L);
        number1.setFibonaccis(5L);
        number1.setPrimes(2L);
        number1.setPrimes(3L);
        number1.setPrimes(5L);
        number1.setPrimes(7L);

        numbers.add(number1);

        return numbers;
    }

}