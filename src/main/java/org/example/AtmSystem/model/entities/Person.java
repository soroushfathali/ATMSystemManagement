package model.entities;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private String FirstName;
    private String LastName;
    private String NationalCode;
    private String PhoneNumber;
}
