package com.giovane.soccer.controller.v1;

import com.giovane.soccer.controller.model.request.TeamControllerRequest;
import com.giovane.soccer.controller.model.response.TeamControllerResponse;
import com.giovane.soccer.service.model.request.TeamServiceRequest;
import com.giovane.soccer.service.model.response.TeamServiceResponse;
import com.giovane.soccer.service.v1.TeamFacade;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import static com.giovane.soccer.controller.mapper.request.TeamControllerRequestMapper.toTeamService;
import static com.giovane.soccer.controller.mapper.response.TeamControllerResponseMapper.toTeamControllerResponse;

@AllArgsConstructor
@Component
public class TeamControllerFacade {

    private final TeamFacade facade;

    public Mono<TeamControllerResponse> saveTeam(TeamControllerRequest team) {
        TeamServiceRequest teamSave = toTeamService(team);
        Mono<TeamServiceResponse> teamResponse = facade.saveTeam(teamSave);
        return toTeamControllerResponse(teamResponse);
    }

}
