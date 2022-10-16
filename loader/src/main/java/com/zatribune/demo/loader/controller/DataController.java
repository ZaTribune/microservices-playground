package com.zatribune.demo.loader.controller;


import com.zatribune.demo.loader.db.entities.Product;
import com.zatribune.demo.loader.db.entities.Storefront;
import com.zatribune.demo.loader.service.DataService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@Slf4j
@AllArgsConstructor
@RequestMapping("/data")
@RestController
public class DataController {


    private final DataService dataService;


    @GetMapping(value = "/storefronts", produces = MediaType.APPLICATION_NDJSON_VALUE)
    public Flux<Storefront> getStorefrontsData() {
        return Flux.fromIterable(dataService.getStorefrontsData());
                //.delayElements(Duration.ofMillis(10));
    }


    @GetMapping(value = "/products", produces = MediaType.APPLICATION_NDJSON_VALUE)
    public Flux<Product> getProductsData() {
        return Flux.fromIterable(dataService.getProductsData());
    }
}
