package model.entities;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Account extends BaseEntity {
    private String NumberAccount;
    private int pin;
    private Double balance;
    private CardStatus cardStatus;

}
