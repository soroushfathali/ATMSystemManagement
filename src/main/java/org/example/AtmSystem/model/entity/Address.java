package org.example.AtmSystem.model.entity;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Address {
    private String city;
    private String street;
    private String houseNumber;
}