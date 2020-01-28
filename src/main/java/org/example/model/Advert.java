package org.example.model;

import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Advert {
    private int id;
    private int userId;
    private String title;
    private String body;
    private String category;
    private String phoneNumber;
    private Date created;
}
