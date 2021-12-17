package com.giovane.soccer.controller.model.response;

import com.giovane.soccer.entity.team.Team;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class LeagueControllerResponse {
    private String id;
    private String name;
    private String type;
    private String icon;
    private List<Team> teams;
}
