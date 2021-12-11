package com.giovane.soccer.service.team;

import com.giovane.soccer.service.model.request.TeamServiceRequest;
import com.giovane.soccer.service.model.response.TeamServiceResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Component
public class TeamFacade {

    private final TeamService service;

    public Mono<TeamServiceResponse> saveTeam(TeamServiceRequest teamRequest) {
        return service.saveTeam(teamRequest);
    }

    public Mono<TeamServiceResponse> updateTeamById(TeamServiceRequest teamRequest, String id) {
        return service.findTeamById(id)
                .flatMap(val -> service.updateTeamById(teamRequest, val.getId()));
    }

    public Mono<Void> deleteTeamById(String id) {
        return service.findTeamById(id)
                .flatMap(val -> service.deleteTeamById(val.getId()));
    }

    public Mono<TeamServiceResponse> findTeamById(String id) {
        return service.findTeamById(id);
    }

    public Flux<TeamServiceResponse> findAllTeams() {
        return service.findAllTeams();
    }

}
