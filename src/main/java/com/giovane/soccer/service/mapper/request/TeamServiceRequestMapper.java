package com.giovane.soccer.service.mapper.request;

import com.giovane.soccer.entity.team.Team;
import com.giovane.soccer.service.model.request.TeamServiceRequest;

public interface TeamServiceRequestMapper {

    static Team toTeamEntity(TeamServiceRequest teamRequest) {
        if (teamRequest == null) {
            return null;
        }

        return Team.builder()
                .id(teamRequest.getId())
                .name(teamRequest.getName())
                .stadium(teamRequest.getStadium())
                .icon(teamRequest.getIcon())
                .bio(teamRequest.getBio())
                .country(teamRequest.getCountry())
                .player(teamRequest.getPlayer())
                .date(teamRequest.getDate())
                .build();
    }

}
