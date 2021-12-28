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
    private String icon;
    private String bio;
    private Integer age;
    private Integer number;
    private Position position;
    private Double height;
    private String nationality;
    private Team currentTeam;
}
