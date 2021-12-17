package com.giovane.soccer.service.mapper.response;

import com.giovane.soccer.entity.league.League;
import com.giovane.soccer.service.model.response.LeagueServiceResponse;

public interface LeagueServiceResponseMapper {

    static LeagueServiceResponse toLeagueServiceResponse(League league) {
        if (league == null) {
            return null;
        }

        return LeagueServiceResponse.builder()
                .id(league.getId())
                .name(league.getName())
                .type(league.getType())
                .icon(league.getIcon())
                .teams(league.getTeams())
                .build();
    }

}
