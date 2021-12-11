package com.giovane.soccer.controller.mapper.request;

import com.giovane.soccer.controller.model.request.TeamControllerRequest;
import com.giovane.soccer.service.v1.model.request.TeamServiceRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TeamControllerRequestMapper {

    static TeamServiceRequest toTeamService(TeamControllerRequest teamRequest){
        return Mappers.getMapper(TeamControllerRequestMapper.class)
                .mapper(teamRequest);
    }

    TeamServiceRequest mapper(TeamControllerRequest teamRequest);

}
