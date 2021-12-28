package com.giovane.soccer.entity.team;

import lombok.*;
import java.util.List;
import java.time.LocalDate;
import org.springframework.data.annotation.*;
import com.giovane.soccer.entity.player.Player;
import org.springframework.data.mongodb.core.mapping.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Document(collection = "teams")
public class Team {
    @Id
    private String id;
    private String name;
    private String icon;
    private String bio;
    private String founded;
    private String stadium;
    private String capacity;
    private String country;
    private String manager;
    private String president;
    private List<Player> player;
    private LocalDate date;
}
