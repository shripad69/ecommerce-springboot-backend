package com.example.e_commerce.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




// added in notes
@RestController
@RequestMapping("/api")

public class ProductController {
    @GetMapping("/")
    public String Greet () {
        return "hey boys";
    }
}
