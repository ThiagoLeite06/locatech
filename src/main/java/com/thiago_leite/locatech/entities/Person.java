package com.thiago_leite.locatech.entities;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Person {
    private Long id;
    private String name;
    private String cpf;
    private String phone;
    private String email;
}
