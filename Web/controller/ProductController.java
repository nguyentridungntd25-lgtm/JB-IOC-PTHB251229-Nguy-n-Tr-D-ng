package com.example.product_management.Spring.Web.controller;

import com.example.product_management.Spring.Web.model.Product;
import com.example.product_management.Spring.Web.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/api/products")
    public List<Product> getProducts() {
        return productService.getAllProducts();
    }
}