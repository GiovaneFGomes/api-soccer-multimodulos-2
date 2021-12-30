package com.giovane.soccer.controller.mapper.response;

import com.giovane.soccer.controller.model.response.TeamControllerResponse;
import com.giovane.soccer.service.model.response.TeamServiceResponse;

public interface TeamControllerResponseMapper {

    static TeamControllerResponse toTeamControllerResponse(TeamServiceResponse teamServiceResponse) {
        if (teamServiceResponse == null) {
            return null;
        }

        return TeamControllerResponse.builder()
                .id(teamServiceResponse.getId())
                .name(teamServiceResponse.getName())
                .icon(teamServiceResponse.getIcon())
                .bio(teamServiceResponse.getBio())
                .founded(teamServiceResponse.getFounded())
                .stadium(teamServiceResponse.getStadium())
                .capacity(teamServiceResponse.getCapacity())
                .country(teamServiceResponse.getCountry())
                .manager(teamServiceResponse.getManager())
                .president(teamServiceResponse.getPresident())
                .player(teamServiceResponse.getPlayer())
                .date(teamServiceResponse.getDate())
                .build();
    }

}
