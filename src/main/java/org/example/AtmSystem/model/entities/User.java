package model.entities;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User extends Person{
    private String username;
    private String password;
    private Role role;
    private Address address;
}
