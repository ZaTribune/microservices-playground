package com.zatribune.demo.orchestrator.domain;


import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Inventory {

    private Long id;

    private String name;
    private String title;
    private String logo;
    private String info;
    private String description;

    private String m1;
    private String m2;
    private String m3;
    private String m4;
    private String m5;
    private String m6;
    private String m7;
    private String m8;
    private String m9;
    private String m10;

    private LocalDateTime creationDate;

    private LocalDateTime updateDate;

    private Integer quantity;
}
