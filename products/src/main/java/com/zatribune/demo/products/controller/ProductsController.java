package com.zatribune.demo.products.controller;

import com.zatribune.demo.products.db.entities.Product;
import com.zatribune.demo.products.db.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductsController {

    private final ProductRepository productRepository;


    @GetMapping("/product/{id}")
    public Product getProduct(@PathVariable Long id){
        log.info("Finding product by id {}",id);
        return productRepository.findById(id)
                .orElseThrow();
    }
}
