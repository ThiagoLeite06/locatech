package com.thiago_leite.locatech.entities;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Vehicle {
    private Long id;
    private String brand;
    private String model;
    private String plate;
    private int year;
    private String color;
    private BigDecimal dailyValue;
}
