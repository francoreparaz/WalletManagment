package com.proyect.walletmanagment.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HelloWorld {

    @RequestMapping(method = RequestMethod.GET)
    public String sayHello(){
        return "Hello World";
    }
}
