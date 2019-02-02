package com.gfarkas.euler.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NaviController {

    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("name", Math.random());
        return "index";
    }
}