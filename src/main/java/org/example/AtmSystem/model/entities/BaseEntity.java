package model.entities;


import lombok.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BaseEntity {
    private long id;
    private Timestamp registerDate = Timestamp.valueOf(LocalDateTime.now());
}
