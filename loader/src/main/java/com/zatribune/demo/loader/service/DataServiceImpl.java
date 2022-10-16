package com.zatribune.demo.loader.service;


import com.zatribune.demo.loader.db.entities.Product;
import com.zatribune.demo.loader.db.entities.Storefront;
import com.zatribune.demo.loader.db.repository.ProductRepository;
import com.zatribune.demo.loader.db.repository.StorefrontRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@AllArgsConstructor
@Service
public class DataServiceImpl implements DataService{

    private final StorefrontRepository storefrontRepository;

    private final ProductRepository productRepository;


    @Override
    public List<Storefront> getStorefrontsData() {
        return storefrontRepository.findAll();
    }

    @Override
    public List<Product> getProductsData() {
        return productRepository.findAll();
    }
}
