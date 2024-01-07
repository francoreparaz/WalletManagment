package com.proyect.springbootwalletmanagment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HelloWord {
    @RequestMapping(method = RequestMethod.GET)
   public String sayHello(){
       return "Hello World";
   }
}
