package com.giovane.soccer.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Document(collection = "teams")
public class Team {
    @Id
    private String id;
    private String name;
    private String stadium;
    private String country;
}
