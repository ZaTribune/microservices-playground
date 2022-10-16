package com.zatribune.demo.products.db.client;

import com.zatribune.demo.products.db.entities.Product;
import com.zatribune.demo.products.db.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Objects;

@Slf4j
@Profile(value = "h2")
@Component
public class DataClient {



    private final WebClient webClient;

    private final ProductRepository productRepository;


    @Autowired
    public DataClient(ProductRepository productRepository) {
        this.webClient = WebClient.builder()
                .build();
        this.productRepository = productRepository;
        loadInitData();
    }


    private void loadInitData(){
        log.info("Loading init data from main db");
        List<Product>list=webClient.get()
                .uri("http://localhost:8081/data/products")
                .accept(MediaType.APPLICATION_NDJSON)
                .exchangeToFlux(clientResponse -> clientResponse.bodyToFlux(Product.class))
                .collectList()
                .block();

        productRepository.saveAll(Objects.requireNonNull(list));
    }
}
