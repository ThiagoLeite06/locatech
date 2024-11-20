package com.thiago_leite.locatech.entities;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Rental {
    private Long id;
    private Long personId;
    private Long vehicleId;
    private String vehicleModel;
    private String personCPF;
    private String personName;
    private LocalDate startDate;
    private LocalDate endDate;
    private BigDecimal totalValue;
}
