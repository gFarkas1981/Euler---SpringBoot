package com.gfarkas.euler.controller;

import com.gfarkas.euler.domain.Number;
import com.gfarkas.euler.service.NumberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
public class MainController {

    private NumberService numberService;

    public void setNumberService(NumberService numberService) {
        this.numberService = numberService;
    }

    @RequestMapping("/number")
    public String number(Model model) {
        model.addAttribute("number", numberService.getNumbers());
        return "number";
    }


    @RequestMapping("/")
    public String viewHome(Model model) {
        model.addAttribute("name", (int) (Math.random() * 10000));
        return "index";
    }


   

}