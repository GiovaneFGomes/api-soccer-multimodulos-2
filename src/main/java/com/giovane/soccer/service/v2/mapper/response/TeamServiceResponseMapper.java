package com.giovane.soccer.service.v2.mapper.response;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import com.giovane.soccer.entity.team.Team;
import com.giovane.soccer.service.v2.model.response.TeamServiceResponse;

@Mapper
public interface TeamServiceResponseMapper {

    static TeamServiceResponse toTeamServiceResponse(Team team){
        return Mappers.getMapper(TeamServiceResponseMapper.class)
                .mapper(team);
    }

    TeamServiceResponse mapper(Team team);

}
