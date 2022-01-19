package com.giovane.soccer.service.team;

import com.giovane.soccer.entity.team.Team;
import lombok.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.springframework.stereotype.*;
import com.giovane.soccer.repository.team.TeamRepository;
import org.springframework.web.server.ResponseStatusException;
import static org.springframework.http.HttpStatus.*;

@AllArgsConstructor
@Service
public class TeamService {

    private final TeamRepository teamRepository;

    public Mono<Team> save(Team team) {
        return teamRepository.save(team);
    }

    public Mono<Team> addPlayer(String id, String playerId) {
        return null;
    }

    public Mono<Void> deleteById(String id) {
       return teamRepository.deleteById(id);
    }

    public Mono<Team> findById(String id) {
        return teamRepository.findById(id)
                .switchIfEmpty(Mono.error(new ResponseStatusException(NOT_FOUND, "ID not found")));
    }

    public Flux<Team> findAll() {
        return teamRepository.findAll();
    }

}
