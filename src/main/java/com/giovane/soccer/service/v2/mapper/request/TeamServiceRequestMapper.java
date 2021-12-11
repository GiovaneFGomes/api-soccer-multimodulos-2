package com.giovane.soccer.service.v2.mapper.request;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import com.giovane.soccer.entity.team.Team;
import com.giovane.soccer.service.v2.model.request.TeamServiceRequest;

@Mapper
public interface TeamServiceRequestMapper {

    static Team toTeamEntity(TeamServiceRequest teamRequest){
        return Mappers.getMapper(TeamServiceRequestMapper.class)
                .mapper(teamRequest);
    }

    Team mapper(TeamServiceRequest teamRequest);

}
