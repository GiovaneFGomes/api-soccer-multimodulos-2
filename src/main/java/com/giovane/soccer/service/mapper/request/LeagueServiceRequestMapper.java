package com.giovane.soccer.service.mapper.request;

import com.giovane.soccer.entity.league.League;
import com.giovane.soccer.service.model.request.LeagueServiceRequest;

public interface LeagueServiceRequestMapper {

    static League toLeagueEntity(LeagueServiceRequest leagueRequest) {

        if (leagueRequest == null) {
            return null;
        }

        return League.builder()
                .id(leagueRequest.getId())
                .name(leagueRequest.getName())
                .type(leagueRequest.getType())
                .icon(leagueRequest.getIcon())
                .teams(leagueRequest.getTeams())
                .build();
    }

}
