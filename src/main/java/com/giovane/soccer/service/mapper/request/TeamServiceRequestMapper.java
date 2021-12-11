package com.giovane.soccer.service.mapper.request;

import com.giovane.soccer.entity.team.Team;
import com.giovane.soccer.service.model.request.TeamServiceRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TeamServiceRequestMapper {

    static Team toTeamEntity(TeamServiceRequest teamRequest){
        return Mappers.getMapper(TeamServiceRequestMapper.class)
                .mapper(teamRequest);
    }

    Team mapper(TeamServiceRequest teamRequest);

}
