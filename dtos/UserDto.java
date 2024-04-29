package org.example.AtmSystem.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;

@Getter
@Setter
@ToString

public class UserDto {
    private long id;
    private Timestamp registerDate;
    private String firstName;
    private String lastName;
    private String nationalCode;
    private String password;
    private String phoneNumber;
    private String cardNumber;
    private String issueDate;

}
