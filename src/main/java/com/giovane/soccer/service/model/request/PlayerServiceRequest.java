package com.giovane.soccer.service.model.request;

import lombok.*;
import com.giovane.soccer.commons.Position;
import com.giovane.soccer.entity.team.Team;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class PlayerServiceRequest {
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
