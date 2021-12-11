package com.giovane.soccer.controller.team;

import com.giovane.soccer.controller.mapper.request.TeamControllerRequestMapper;
import com.giovane.soccer.controller.mapper.response.TeamControllerResponseMapper;
import com.giovane.soccer.controller.model.response.TeamControllerResponse;
import com.giovane.soccer.controller.model.request.TeamControllerRequest;
import com.giovane.soccer.service.model.request.TeamServiceRequest;
import com.giovane.soccer.service.model.response.TeamServiceResponse;
import com.giovane.soccer.service.team.TeamFacade;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Component
public class TeamControllerFacade {

    private final TeamFacade facade;

    public Mono<TeamControllerResponse> saveTeam(TeamControllerRequest teamRequest) {
        TeamServiceRequest teamService = TeamControllerRequestMapper.toTeamService(teamRequest);
        Mono<TeamServiceResponse> teamServiceResponseMono = facade.saveTeam(teamService);
        return teamServiceResponseMono.map(TeamControllerResponseMapper::toTeamControllerResponse);
    }

    public Mono<TeamControllerResponse> updateTeamById(TeamControllerRequest teamRequest, String id) {
        TeamServiceRequest teamService = TeamControllerRequestMapper.toTeamService(teamRequest);
        Mono<TeamServiceResponse> teamServiceResponseMono = facade.updateTeamById(teamService, id);
        return teamServiceResponseMono.map(TeamControllerResponseMapper::toTeamControllerResponse);
    }

    public Mono<Void> deleteTeamById(String id) {
        return facade.deleteTeamById(id);
    }

    public Mono<TeamControllerResponse> findTeamById(String id) {
        Mono<TeamServiceResponse> teamServiceResponseMono = facade.findTeamById(id);
        return teamServiceResponseMono.map(TeamControllerResponseMapper::toTeamControllerResponse);
    }

    public Flux<TeamControllerResponse> findAllTeams() {
        return facade.findAllTeams()
                .map(TeamControllerResponseMapper::toTeamControllerResponse);
    }

}
