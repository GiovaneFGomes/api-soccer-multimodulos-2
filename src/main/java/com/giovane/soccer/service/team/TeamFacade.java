package com.giovane.soccer.service.team;

import com.giovane.soccer.entity.team.Team;
import com.giovane.soccer.service.mapper.request.TeamServiceRequestMapper;
import com.giovane.soccer.service.mapper.response.TeamServiceResponseMapper;
import com.giovane.soccer.service.model.request.TeamServiceRequest;
import com.giovane.soccer.service.model.response.TeamServiceResponse;
import com.giovane.soccer.service.player.PlayerService;
import lombok.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.springframework.stereotype.*;

import static com.giovane.soccer.service.mapper.request.TeamServiceRequestMapper.toTeamEntity;

@AllArgsConstructor
@Component
public class TeamFacade {

    private final TeamService teamService;
    private final PlayerService playerService;

    public Mono<TeamServiceResponse> save(TeamServiceRequest teamServiceRequest) {
        return teamService.save(toTeamEntity(teamServiceRequest))
                .map(TeamServiceResponseMapper::toTeamControllerResponse);
    }

    public Mono<TeamServiceResponse> update(TeamServiceRequest teamServiceRequest) {
        return teamService.findById(teamServiceRequest.getId())
                .flatMap(val -> teamService.save(toTeamEntity(teamServiceRequest)))
                .map(TeamServiceResponseMapper::toTeamControllerResponse);
    }

    // TODO fazer um patch para o atributo bio, para ter a opção de atualizar a bio do Team e Player

//    public Mono<TeamServiceResponse> addPlayer(String teamId, String playerId) {
//        return Mono.just(new Team())
//                .zipWith(teamService.findById(teamId), TeamModelMapper.mapper(team))
//                .zipWith(playerService.findById(playerId), addPlayer(teamId, playerId))
//                .map(teamService.save());
//    }

    public Mono<Void> deleteById(String id) {
        return teamService.findById(id)
                .flatMap(val -> teamService.deleteById(val.getId()));
    }

    public Mono<TeamServiceResponse> findById(String id) {
        return teamService.findById(id)
                .map(TeamServiceResponseMapper::toTeamControllerResponse);
    }

    public Flux<TeamServiceResponse> findAll() {
        return teamService.findAll()
                .map(TeamServiceResponseMapper::toTeamControllerResponse);
    }

}
