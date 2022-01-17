package com.giovane.soccer.service.team;

import com.giovane.soccer.entity.team.Team;
import lombok.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.springframework.stereotype.*;
import com.giovane.soccer.repository.team.TeamRepository;
import org.springframework.web.server.ResponseStatusException;
import com.giovane.soccer.service.model.request.TeamServiceRequest;
import com.giovane.soccer.service.model.response.TeamServiceResponse;
import com.giovane.soccer.service.mapper.response.TeamServiceResponseMapper;
import static org.springframework.http.HttpStatus.*;
import static com.giovane.soccer.service.mapper.request.TeamServiceRequestMapper.toTeamEntity;

@AllArgsConstructor
@Service
public class TeamService {

    private final TeamRepository repository;

    public Mono<Team> save(Team team) {
        return repository.save(team);
    }

    public Mono<Team> updateById(Team team) {
        return repository.save(team);
    }

    public Mono<Void> deleteById(String id) {
       return repository.deleteById(id);
    }

    public Mono<Team> findById(String id) {
        return repository.findById(id)
                .switchIfEmpty(Mono.error(new ResponseStatusException(NOT_FOUND, "ID not found")));
    }

    public Flux<Team> findAll() {
        return repository.findAll();
    }

}
