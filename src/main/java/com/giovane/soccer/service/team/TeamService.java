package com.giovane.soccer.service.team;

import com.giovane.soccer.entity.team.Team;
import com.giovane.soccer.service.mapper.request.TeamServiceRequestMapper;
import com.giovane.soccer.service.mapper.response.TeamServiceResponseMapper;
import com.giovane.soccer.service.model.request.TeamServiceRequest;
import com.giovane.soccer.service.model.response.TeamServiceResponse;
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

    public Mono<TeamServiceResponse> addPlayer(String teamId, String playerId) {
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
