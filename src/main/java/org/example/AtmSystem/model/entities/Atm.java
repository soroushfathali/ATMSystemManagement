package model.entities;

import lombok.*;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Atm {
    private int TransactionID;

    private Date date;
}
