package org.example.AtmSystem.model.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Customer extends User {

    private String NoCard;
}
