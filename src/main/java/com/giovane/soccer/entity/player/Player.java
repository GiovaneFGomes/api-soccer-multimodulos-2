package com.giovane.soccer.entity.player;

import lombok.*;
import com.giovane.soccer.entity.team.Team;
import com.giovane.soccer.commons.Position;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Document(collection = "players")
public class Player {
    @Id
    private String id;
    private String name;
    private Integer age;
    private String nationality;
    private String icon;
    private String bio;
    private Team actualTeam;
    private Integer number;
    private Position position;
    private Double height;
}
