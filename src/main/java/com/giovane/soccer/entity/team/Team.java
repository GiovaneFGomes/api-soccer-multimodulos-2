package com.giovane.soccer.entity.team;

import com.giovane.soccer.entity.player.Player;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

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
    private List<Player> player;
    private LocalDate date;
}
