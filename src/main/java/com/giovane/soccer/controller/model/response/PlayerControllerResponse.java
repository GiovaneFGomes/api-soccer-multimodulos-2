package com.giovane.soccer.controller.model.response;

import lombok.*;
import com.giovane.soccer.entity.team.Team;
import com.giovane.soccer.commons.Position;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class PlayerControllerResponse {
    private String id;
    private String name;
    private Integer age;
    private String nationality;
    private Team actualTeam;
    private Integer number;
    private Position position;
    private Double height;
}
