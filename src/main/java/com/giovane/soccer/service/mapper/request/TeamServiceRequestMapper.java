package com.giovane.soccer.service.mapper.request;

import com.giovane.soccer.entity.Team;
import com.giovane.soccer.service.model.request.TeamServiceRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TeamServiceRequestMapper {

    static Team toTeamEntity(TeamServiceRequest team){
        return Mappers.getMapper(TeamServiceRequestMapper.class)
                .mapper(team);
    }

    Team mapper(TeamServiceRequest team);

}
