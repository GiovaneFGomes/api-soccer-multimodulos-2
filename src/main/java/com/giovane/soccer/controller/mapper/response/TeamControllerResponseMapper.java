package com.giovane.soccer.controller.mapper.response;

import com.giovane.soccer.controller.model.response.TeamControllerResponse;
import com.giovane.soccer.service.model.response.TeamServiceResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import reactor.core.publisher.Mono;

@Mapper
public interface TeamControllerResponseMapper {

    static Mono<TeamControllerResponse> toTeamControllerResponse(Mono<TeamServiceResponse> teamResponseService) {
        return Mappers.getMapper(TeamControllerResponseMapper.class)
                .mapper(teamResponseService);
    }

    Mono<TeamControllerResponse> mapper(Mono<TeamServiceResponse> teamResponse);

}