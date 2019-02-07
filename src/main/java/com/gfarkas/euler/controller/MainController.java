package com.gfarkas.euler.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MainController {


    @RequestMapping("/")
    public String viewHome(Model model) {
        model.addAttribute("name", (int) (Math.random() * 10000));
        return "index";
    }

}