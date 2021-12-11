package com.giovane.soccer.service.v2.model.request;

import lombok.*;
import com.giovane.soccer.utils.Position;
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
    private Team actualTeam;
    private Integer number;
    private Position position;
    private Double height;
}
