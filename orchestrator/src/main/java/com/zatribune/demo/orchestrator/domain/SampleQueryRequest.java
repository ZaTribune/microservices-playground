package com.zatribune.demo.orchestrator.domain;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class SampleQueryRequest {
    private Long product;
    private Long storefront;
}
