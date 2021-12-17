package com.giovane.soccer.controller.mapper.request;

import com.giovane.soccer.controller.model.request.LeagueControllerRequest;
import com.giovane.soccer.service.model.request.LeagueServiceRequest;

public interface LeagueControllerRequestMapper {

    static LeagueServiceRequest toLeagueServiceRequest(LeagueControllerRequest leagueRequest) {

        if (leagueRequest == null) {
            return null;
        }

        return LeagueServiceRequest.builder()
                .id(leagueRequest.getId())
                .name(leagueRequest.getName())
                .type(leagueRequest.getType())
                .icon(leagueRequest.getIcon())
                .teams(leagueRequest.getTeams())
                .build();
    }

}
