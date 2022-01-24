package com.giovane.soccer.controller.mapper.request;

import com.giovane.soccer.controller.model.request.TeamControllerRequest;
import com.giovane.soccer.service.model.request.TeamServiceRequest;

public class TeamControllerRequestMapper {

    public static TeamServiceRequest toTeamServiceWithId(TeamControllerRequest teamControllerRequest, String id) {

        return TeamServiceRequest.builder()
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

    public static TeamServiceRequest toTeamServiceWithoutId(TeamControllerRequest teamControllerRequest) {

        return TeamServiceRequest.builder()
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
