package com.giovane.soccer.entity.team;

import lombok.*;
import java.util.List;
import java.time.LocalDate;
import com.giovane.soccer.entity.player.Player;
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
    private String icon;
    private String bio;
    private String country;
    private List<Player> player;
    private LocalDate date;
}
