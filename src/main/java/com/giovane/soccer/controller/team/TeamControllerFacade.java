package com.giovane.soccer.controller.team;

import lombok.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.springframework.stereotype.*;
import com.giovane.soccer.service.team.TeamFacade;
import com.giovane.soccer.controller.model.request.TeamControllerRequest;
import com.giovane.soccer.controller.model.response.TeamControllerResponse;
import com.giovane.soccer.controller.mapper.response.TeamControllerResponseMapper;
import static com.giovane.soccer.controller.mapper.request.TeamControllerRequestMapper.toTeamEntityWithId;
import static com.giovane.soccer.controller.mapper.request.TeamControllerRequestMapper.toTeamEntityWithoutId;

@AllArgsConstructor
@Component
public class TeamControllerFacade {

    private final TeamFacade facade;

    public Mono<TeamControllerResponse> save(TeamControllerRequest teamControllerRequest) {
        return facade.save(toTeamEntityWithoutId(teamControllerRequest))
                .map(TeamControllerResponseMapper::toTeamControllerResponse);
    }

    public Mono<TeamControllerResponse> update(TeamControllerRequest teamControllerRequest, String id) {
        return facade.update(toTeamEntityWithId(teamControllerRequest, id))
                .map(TeamControllerResponseMapper::toTeamControllerResponse);
    }

//    public Mono<TeamControllerResponse> addPlayer(String id, String playerId) {
//        return null;
//    }

    public Mono<Void> deleteById(String id) {
        return facade.deleteById(id);
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
