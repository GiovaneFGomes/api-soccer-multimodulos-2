package com.giovane.soccer.service.model.response;

import lombok.*;
import com.giovane.soccer.commons.Position;
import com.giovane.soccer.entity.team.Team;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class PlayerServiceResponse {
    private String id;
    private String name;
    private Integer age;
    private String nationality;
    private Team actualTeam;
    private Integer number;
    private Position position;
    private Double height;
}
