package org.example.AtmSystem.model.dtos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.example.AtmSystem.model.entity.CardStatus;

import java.sql.Timestamp;

@Getter
@Setter
@ToString
public class AccountDto {
    private long id;
    private String NumberAccount;
    private Timestamp expiredDate;
    private short cvv2;
    private int pin;
    private Double balance;
    private CardStatus cardStatus;
}
