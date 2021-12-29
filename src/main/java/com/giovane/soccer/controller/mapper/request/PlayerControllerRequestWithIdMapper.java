package com.giovane.soccer.controller.mapper.request;

import com.giovane.soccer.service.model.request.TeamServiceRequest;

public interface PlayerControllerRequestWithIdMapper {

    static TeamServiceRequest toTeamServiceRequestControllerWithId(TeamServiceRequest teamServiceRequest1, String id) {

        if (teamServiceRequest1 == null && id == null) {
            return null;
        }

        TeamServiceRequest.TeamServiceRequestBuilder teamServiceRequest = TeamServiceRequest.builder();

        if (teamServiceRequest1 != null) {
            teamServiceRequest.name(teamServiceRequest1.getName());
        }
        if (id != null) {
            teamServiceRequest.id(id);
        }

        return teamServiceRequest.build();
    }

}
