package com.example.e_commerce.controller;

import com.example.e_commerce.model.Product;
import com.example.e_commerce.service.ProdcutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


// added in notes
@RestController
@RequestMapping("/api")

public class ProductController {

    @Autowired
    private ProdcutService service;

    @GetMapping("/")
    public String Greet () {
        return "hey boys";
    }

    @GetMapping("/all")
    public List<Product> GetAllProducts () {
        return service.getAllProducts();
    }


}
