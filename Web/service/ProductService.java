package com.example.product_management.Spring.Web.service;

import com.example.product_management.Spring.Web.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private List<Product> products = new ArrayList<>();

    public ProductService() {
        products.add(new Product(1, "Laptop", 1500));
        products.add(new Product(2, "Mouse", 20));
        products.add(new Product(3, "Keyboard", 50));
    }

    public List<Product> getAllProducts() {
        return products;
    }
}