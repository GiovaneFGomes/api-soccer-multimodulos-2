package com.giovane.soccer.service.team;

import com.giovane.soccer.entity.team.Team;
import lombok.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.springframework.stereotype.*;

@AllArgsConstructor
@Component
public class TeamFacade {

    private final TeamService service;
//    private final PlayerService playerService;

    public Mono<Team> save(Team team) {
        return service.save(team);
    }

    public Mono<Team> update(Team team) {
        return service.findById(team.getId())
                .flatMap(val -> service.update(team));
    }

    public Mono<Void> deleteById(String id) {
        return service.findById(id)
                .flatMap(val -> service.deleteById(val.getId()));
    }

    public Mono<Team> findById(String id) {
        return service.findById(id);
    }

    public Flux<Team> findAll() {
        return service.findAll();
    }

}
