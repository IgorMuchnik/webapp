package org.example.model;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Advert {
    private long id;
    private long userId;
    private String title;
    private String body;
    private String category;
    private String phoneNumber;
    private LocalDate created;
}
