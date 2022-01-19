package com.giovane.soccer.service.team;

import com.giovane.soccer.entity.team.Team;
import com.giovane.soccer.service.player.PlayerService;
import lombok.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.springframework.stereotype.*;

@AllArgsConstructor
@Component
public class TeamFacade {

    private final TeamService teamService;
    private final PlayerService playerService;

    public Mono<Team> save(Team team) {
        return teamService.save(team);
    }

    public Mono<Team> update(Team team) {
        return teamService.findById(team.getId())
                .flatMap(val -> teamService.save(team));
    }

    // todo fazer o patch para o atributo bio

//    public Mono<Team> addPlayer(String teamId, String playerId) {
//        return Mono.just(new Team())
//                .zipWith(teamService.findById(teamId), TeamModelMapper.mapper(team))
//                .zipWith(playerService.findById(playerId), addPlayer(teamId, playerId))
//                .map(teamService.save());
//    }

    public Mono<Void> deleteById(String id) {
        return teamService.findById(id)
                .flatMap(val -> teamService.deleteById(val.getId()));
    }

    public Mono<Team> findById(String id) {
        return teamService.findById(id);
    }

    public Flux<Team> findAll() {
        return teamService.findAll();
    }

}
