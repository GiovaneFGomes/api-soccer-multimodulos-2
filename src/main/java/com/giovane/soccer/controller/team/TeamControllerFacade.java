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

import static com.giovane.soccer.controller.mapper.request.TeamControllerRequestMapper.toTeamService;

@AllArgsConstructor
@Component
public class TeamControllerFacade {

    private final TeamFacade facade;

    public Mono<TeamControllerResponse> save(TeamControllerRequest teamRequest) {
        return facade.save(toTeamService(teamRequest))
                .map(TeamControllerResponseMapper::toTeamControllerResponse);
    }

    public Mono<TeamControllerResponse> update(TeamControllerRequest teamRequest, String id) {
        return facade.update(toTeamService(teamRequest), id)
                .map(TeamControllerResponseMapper::toTeamControllerResponse);
    }

    public Mono<Void> delete(String id) {
        return facade.delete(id);
    }

    public Mono<TeamControllerResponse> findById(String id) {
        return facade.findById(id)
                .map(TeamControllerResponseMapper::toTeamControllerResponse);
    }

    public Flux<TeamControllerResponse> findAll() {
        return facade.findAll()
                .map(TeamControllerResponseMapper::toTeamControllerResponse);
    }

}
