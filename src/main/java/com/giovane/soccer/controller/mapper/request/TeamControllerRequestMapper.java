package com.giovane.soccer.controller.mapper.request;

import com.giovane.soccer.controller.model.request.TeamControllerRequest;
import com.giovane.soccer.service.model.request.TeamServiceRequest;

public interface TeamControllerRequestMapper {

    static TeamServiceRequest toTeamServiceRequest(TeamControllerRequest teamControllerRequest) {
        if (teamControllerRequest == null) {
            return null;
        }

        return TeamServiceRequest.builder()
                .id(teamControllerRequest.getId())
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
