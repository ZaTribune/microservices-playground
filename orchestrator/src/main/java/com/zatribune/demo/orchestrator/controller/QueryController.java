package com.zatribune.demo.orchestrator.controller;


import com.zatribune.demo.orchestrator.domain.SampleQueryResponse;
import com.zatribune.demo.orchestrator.domain.Product;
import com.zatribune.demo.orchestrator.domain.SampleQueryRequest;
import com.zatribune.demo.orchestrator.domain.Storefront;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Slf4j
@AllArgsConstructor
@RequestMapping("/query")
@RestController
public class QueryController {

    private final WebClient webClient;

    public QueryController() {
        webClient = WebClient.builder().build();
    }

    @PostMapping("/product/zipped")
    public SampleQueryResponse findProductAvailabilityV2(@RequestBody SampleQueryRequest request) {

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Mono<Product> call1 = webClient.get()
                .uri("http://localhost:8083/products/product/" + request.getProduct())
                .exchangeToMono(clientResponse -> clientResponse.bodyToMono(Product.class));

        Mono<Storefront> call2 = webClient.get()
                .uri("http://localhost:8082/storefronts/storefront/" + request.getStorefront())
                .exchangeToMono(clientResponse -> clientResponse.bodyToMono(Storefront.class));


        SampleQueryResponse p = call1.zipWith(call2).map(result ->
                SampleQueryResponse.builder()
                        .product(result.getT1())
                        .storefront(result.getT2())
                        .build()
        ).block();


        stopWatch.stop();
        log.info("Request was served in {} ms", stopWatch.getTotalTimeMillis());

        return p;
    }

    @PostMapping("/product")
    public SampleQueryResponse findProductAvailability(@RequestBody SampleQueryRequest request) {

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Product call1 = webClient.get()
                .uri("http://localhost:8083/products/product/" + request.getProduct())
                .exchangeToMono(clientResponse -> clientResponse.bodyToMono(Product.class)).block();

        Storefront call2 = webClient.get()
                .uri("http://localhost:8082/storefronts/storefront/" + request.getStorefront())
                .exchangeToMono(clientResponse -> clientResponse.bodyToMono(Storefront.class)).block();


        SampleQueryResponse p =
                SampleQueryResponse.builder()
                        .product(call1)
                        .storefront(call2)
                        .build();


        stopWatch.stop();
        log.info("Request was served in {} ms", stopWatch.getTotalTimeMillis());

        return p;
    }
}
