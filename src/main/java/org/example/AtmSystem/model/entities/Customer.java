package model.entities;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Customer extends User{
    private String cardNumber;
    private String expireDate;
}
