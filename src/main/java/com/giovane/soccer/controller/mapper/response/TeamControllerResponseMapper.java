package com.giovane.soccer.controller.mapper.response;

import com.giovane.soccer.controller.model.response.TeamControllerResponse;
import com.giovane.soccer.entity.team.Team;
import com.giovane.soccer.service.model.response.TeamServiceResponse;

public interface TeamControllerResponseMapper {

    static TeamControllerResponse toTeamControllerResponse(Team team) {

        return TeamControllerResponse.builder()
                .id(team.getId())
                .name(team.getName())
                .icon(team.getIcon())
                .bio(team.getBio())
                .founded(team.getFounded())
                .stadium(team.getStadium())
                .capacity(team.getCapacity())
                .country(team.getCountry())
                .manager(team.getManager())
                .president(team.getPresident())
                .player(team.getPlayer())
                .date(team.getDate())
                .build();
    }

}
