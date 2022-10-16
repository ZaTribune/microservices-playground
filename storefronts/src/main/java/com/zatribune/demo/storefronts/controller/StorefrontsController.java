package com.zatribune.demo.storefronts.controller;


import com.zatribune.demo.storefronts.db.entities.Storefront;
import com.zatribune.demo.storefronts.db.repository.StorefrontRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/storefronts")
public class StorefrontsController {

    private final StorefrontRepository storefrontRepository;


    @GetMapping("/storefront/{id}")
    public Storefront getProduct(@PathVariable Long id){
        log.info("Finding product by id {}",id);
        return storefrontRepository.findById(id)
                .orElseThrow();
    }
}
