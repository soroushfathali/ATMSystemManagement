package org.example.AtmSystem.model.entity;


import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User extends Person {

    private String password;
    private Role role;
}
