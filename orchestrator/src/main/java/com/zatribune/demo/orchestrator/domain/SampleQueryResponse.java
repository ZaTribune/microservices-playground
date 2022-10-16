package com.zatribune.demo.orchestrator.domain;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class SampleQueryResponse {

    private Product product;
    private Storefront storefront;
}
