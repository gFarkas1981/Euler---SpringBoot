package com.gfarkas.euler.controller;


import com.gfarkas.euler.service.Euler1;
import com.gfarkas.euler.service.Euler2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {

    private Euler1 euler1;
    private Euler2 euler2;

    @Autowired
    public void setEuler1(Euler1 euler1) {
        this.euler1 = euler1;
    }

    @Autowired
    public void setEuler1(Euler2 euler2) {
        this.euler2 = euler2;
    }

    @RequestMapping("/euler1")
    public String index1(){
        return euler1.euler1();
    }

    @RequestMapping("/euler2")
    public int index2(){
        return euler2.euler2();
    }

}
