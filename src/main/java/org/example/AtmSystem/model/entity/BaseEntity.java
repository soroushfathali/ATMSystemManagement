package org.example.AtmSystem.model.entity;

import lombok.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class BaseEntity extends Address {
    private long id;
    private Timestamp registerDate = Timestamp.valueOf(LocalDateTime.now());
}


