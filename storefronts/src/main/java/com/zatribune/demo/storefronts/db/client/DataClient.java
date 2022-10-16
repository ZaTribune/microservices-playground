package com.zatribune.demo.storefronts.db.client;

import com.zatribune.demo.storefronts.db.entities.Storefront;
import com.zatribune.demo.storefronts.db.repository.StorefrontRepository;
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

    private final StorefrontRepository storefrontRepository;


    @Autowired
    public DataClient(StorefrontRepository storefrontRepository) {
        this.webClient = WebClient.builder()
                .build();
        this.storefrontRepository=storefrontRepository;
        loadInitData();
    }


    private void loadInitData(){
        log.info("Loading init data from main db");
        List<Storefront>list=webClient.get()
                .uri("http://localhost:8081/data/storefronts")
                .accept(MediaType.APPLICATION_NDJSON)
                .exchangeToFlux(clientResponse -> clientResponse.bodyToFlux(Storefront.class))
                .collectList()
                .block();

        storefrontRepository.saveAll(Objects.requireNonNull(list));
    }
}
