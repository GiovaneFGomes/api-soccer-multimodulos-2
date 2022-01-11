package com.giovane.soccer.service.mapper.request;

import com.giovane.soccer.entity.team.Team;
import com.giovane.soccer.service.model.request.TeamServiceRequest;

public interface TeamServiceRequestMapper {

    static Team toTeamEntity(TeamServiceRequest teamServiceRequest) {
        if (teamServiceRequest == null) {
            return null;
        }

        return Team.builder()
                .id(teamServiceRequest.getId())
                .name(teamServiceRequest.getName())
                .icon(teamServiceRequest.getIcon())
                .bio(teamServiceRequest.getBio())
                .founded(teamServiceRequest.getFounded())
                .stadium(teamServiceRequest.getStadium())
                .capacity(teamServiceRequest.getCapacity())
                .country(teamServiceRequest.getCountry())
                .manager(teamServiceRequest.getManager())
                .president(teamServiceRequest.getPresident())
                .player(teamServiceRequest.getPlayer())
                .date(teamServiceRequest.getDate())
                .build();
    }

}
