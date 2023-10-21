package com.example.demo.controller;


import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Log4j2
@RequestMapping("/")
@Controller
public class CategoryController {


    @GetMapping(value = "/contact")
    public String contect(Model model){
        return "contact/contact";
    }

}
