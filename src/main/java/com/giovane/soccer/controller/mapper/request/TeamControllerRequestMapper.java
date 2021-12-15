package com.giovane.soccer.controller.mapper.request;

import com.giovane.soccer.controller.model.request.TeamControllerRequest;
import com.giovane.soccer.service.model.request.TeamServiceRequest;

//@Mapper
public interface TeamControllerRequestMapper {

    static TeamServiceRequest toTeamService(TeamControllerRequest teamRequest) {
        if (teamRequest == null) {
            return null;
        }

        return TeamServiceRequest.builder()
                .id(teamRequest.getId())
                .name(teamRequest.getName())
                .stadium(teamRequest.getStadium())
                .country(teamRequest.getCountry())
                .player(teamRequest.getPlayer())
                .date(teamRequest.getDate())
                .build();
    }

}

/*
    MAPPER

    static TeamServiceRequest toTeamService(TeamControllerRequest teamRequest){
        return Mappers.getMapper(TeamControllerRequestMapper.class)
                .mapper(teamRequest);
    }

    TeamServiceRequest mapper(TeamControllerRequest teamRequest);

 */