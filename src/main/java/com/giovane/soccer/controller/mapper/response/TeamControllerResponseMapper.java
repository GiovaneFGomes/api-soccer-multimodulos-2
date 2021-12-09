package com.giovane.soccer.controller.mapper.response;

import com.giovane.soccer.controller.model.response.TeamControllerResponse;
import com.giovane.soccer.service.model.response.TeamServiceResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TeamControllerResponseMapper {

    static TeamControllerResponse toTeamControllerResponse(TeamServiceResponse teamResponse) {
        return Mappers.getMapper(TeamControllerResponseMapper.class)
                .mapper(teamResponse);
    }

    TeamControllerResponse mapper(TeamServiceResponse teamResponse);

}