package com.giovane.soccer.service.mapper.response;

import com.giovane.soccer.entity.team.Team;
import com.giovane.soccer.service.model.response.TeamServiceResponse;

public interface TeamServiceResponseMapper {

    static TeamServiceResponse toTeamServiceResponse(Team team) {
        if (team == null) {
            return null;
        }

        return TeamServiceResponse.builder()
                .id(team.getId())
                .name(team.getName())
                .stadium(team.getStadium())
                .icon(team.getIcon())
                .bio(team.getBio())
                .country(team.getCountry())
                .player(team.getPlayer())
                .date(team.getDate())
                .build();
    }

}
