package com.giovane.soccer.controller.mapper.response;

import com.giovane.soccer.controller.model.response.LeagueControllerResponse;
import com.giovane.soccer.service.model.response.LeagueServiceResponse;

public interface LeagueControllerResponseMapper {

    static LeagueControllerResponse toLeagueControllerResponse(LeagueServiceResponse leagueServiceResponse) {
        if (leagueServiceResponse == null) {
            return null;
        }

        return LeagueControllerResponse.builder()
                .id(leagueServiceResponse.getId())
                .name(leagueServiceResponse.getName())
                .type(leagueServiceResponse.getType())
                .icon(leagueServiceResponse.getIcon())
                .teams(leagueServiceResponse.getTeams())
                .build();
    }

}
