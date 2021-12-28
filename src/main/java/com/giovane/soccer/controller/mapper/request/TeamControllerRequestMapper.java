package com.giovane.soccer.controller.mapper.request;

import com.giovane.soccer.controller.model.request.TeamControllerRequest;
import com.giovane.soccer.service.model.request.TeamServiceRequest;

public interface TeamControllerRequestMapper {

    static TeamServiceRequest toTeamServiceRequest(TeamControllerRequest teamRequest) {
        if (teamRequest == null) {
            return null;
        }

        return TeamServiceRequest.builder()
                .id(teamRequest.getId())
                .name(teamRequest.getName())
                .icon(teamRequest.getIcon())
                .bio(teamRequest.getBio())
                .founded(teamRequest.getFounded())
                .stadium(teamRequest.getStadium())
                .capacity(teamRequest.getCapacity())
                .country(teamRequest.getCountry())
                .manager(teamRequest.getManager())
                .president(teamRequest.getPresident())
                .player(teamRequest.getPlayer())
                .date(teamRequest.getDate())
                .build();
    }

}
