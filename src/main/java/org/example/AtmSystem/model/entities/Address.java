package model.entities;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Address {
    private String unite;
    private String city;
    private String town;
    private String StreetName;
    private String houseName;
    private short houseNumber;
}