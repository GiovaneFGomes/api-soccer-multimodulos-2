package com.giovane.soccer.service.team;

import com.giovane.soccer.entity.team.Team;
import com.giovane.soccer.repository.team.TeamRepository;
import com.giovane.soccer.service.mapper.response.TeamServiceResponseMapper;
import com.giovane.soccer.service.model.request.TeamServiceRequest;
import com.giovane.soccer.service.model.response.TeamServiceResponse;
import lombok.*;
import org.springframework.stereotype.*;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import static com.giovane.soccer.service.mapper.request.TeamServiceRequestMapper.toTeamEntity;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@AllArgsConstructor
@Service
public class TeamService {

    private final TeamRepository repository;

    public Mono<TeamServiceResponse> save(TeamServiceRequest teamRequest) {
        return repository.save(toTeamEntity(teamRequest))
                .map(TeamServiceResponseMapper::toTeamServiceResponse); // fecha o pipeline com map que contem ja o subscribe()
    }

    public Mono<TeamServiceResponse> update(TeamServiceRequest teamRequest, String id) {
        teamRequest.setId(id);
        return repository.save(toTeamEntity(teamRequest))
                .map(TeamServiceResponseMapper::toTeamServiceResponse);
    }

    public Mono<Void> delete(String id) {
       return repository.deleteById(id);
    }

    public Mono<TeamServiceResponse> findById(String id) {
        Mono<Team> teamEntityMono = repository.findById(id)
                .switchIfEmpty(Mono.error(new ResponseStatusException(NOT_FOUND, "ID not found")));
        return teamEntityMono.map(TeamServiceResponseMapper::toTeamServiceResponse);
    }

    public Flux<TeamServiceResponse> findAll() {
        return repository.findAll()
                .map(TeamServiceResponseMapper::toTeamServiceResponse);
    }

}
