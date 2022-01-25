package com.giovane.soccer.service.model.request;

import com.giovane.soccer.commons.Position;
import com.giovane.soccer.entity.team.Team;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class PlayerServiceRequest {
    private String id;
    private String name;
    private String icon;
    private String bio;
    private Integer age;
    private Integer number;
    private Position position;
    private Double height;
    private String nationality;
}
