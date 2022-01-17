package com.giovane.soccer.controller.mapper.request;

import com.giovane.soccer.controller.model.request.TeamControllerRequest;
import com.giovane.soccer.entity.team.Team;

public interface TeamControllerRequestMapper {

    static Team toTeamEntityWithoutId(TeamControllerRequest teamControllerRequest) {

        return Team.builder()
                .name(teamControllerRequest.getName())
                .icon(teamControllerRequest.getIcon())
                .bio(teamControllerRequest.getBio())
                .founded(teamControllerRequest.getFounded())
                .stadium(teamControllerRequest.getStadium())
                .capacity(teamControllerRequest.getCapacity())
                .country(teamControllerRequest.getCountry())
                .manager(teamControllerRequest.getManager())
                .president(teamControllerRequest.getPresident())
                .player(teamControllerRequest.getPlayer())
                .date(teamControllerRequest.getDate())
                .build();
    }


    static Team toTeamEntityWithId(TeamControllerRequest teamControllerRequest, String id) {

        return Team.builder()
                .id(id)
                .name(teamControllerRequest.getName())
                .icon(teamControllerRequest.getIcon())
                .bio(teamControllerRequest.getBio())
                .founded(teamControllerRequest.getFounded())
                .stadium(teamControllerRequest.getStadium())
                .capacity(teamControllerRequest.getCapacity())
                .country(teamControllerRequest.getCountry())
                .manager(teamControllerRequest.getManager())
                .president(teamControllerRequest.getPresident())
                .player(teamControllerRequest.getPlayer())
                .date(teamControllerRequest.getDate())
                .build();
    }

}
