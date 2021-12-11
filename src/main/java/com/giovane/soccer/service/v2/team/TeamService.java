package com.giovane.soccer.service.v2.team;

import lombok.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.springframework.stereotype.*;
import com.giovane.soccer.entity.team.Team;
import com.giovane.soccer.repository.team.TeamRepository;
import org.springframework.web.server.ResponseStatusException;
import com.giovane.soccer.service.v2.model.request.TeamServiceRequest;
import com.giovane.soccer.service.v2.model.response.TeamServiceResponse;
import com.giovane.soccer.service.v2.mapper.response.TeamServiceResponseMapper;
import static org.springframework.http.HttpStatus.*;
import static com.giovane.soccer.service.v2.mapper.request.TeamServiceRequestMapper.toTeamEntity;

@AllArgsConstructor
@Service
public class TeamService {

    private final TeamRepository repository;

    public Mono<TeamServiceResponse> saveTeam(TeamServiceRequest teamRequest) {
        Team teamEntity = toTeamEntity(teamRequest);
        Mono<Team> teamEntityMono = repository.save(teamEntity);
        return teamEntityMono.map(TeamServiceResponseMapper::toTeamServiceResponse);
    }

    public Mono<TeamServiceResponse> updateTeamById(TeamServiceRequest teamRequest, String id) {
        teamRequest.setId(id);
        Team teamEntity = toTeamEntity(teamRequest);
        Mono<Team> teamEntityMono = repository.save(teamEntity);
        return teamEntityMono.map(TeamServiceResponseMapper::toTeamServiceResponse);
    }

    public Mono<Void> deleteTeamById(String id) {
       return repository.deleteById(id);
    }

    public Mono<TeamServiceResponse> findTeamById(String id) {
        Mono<Team> teamEntityMono = repository.findById(id)
                .switchIfEmpty(Mono.error(new ResponseStatusException(NOT_FOUND, "ID not found")));
        return teamEntityMono.map(TeamServiceResponseMapper::toTeamServiceResponse);
    }

    public Flux<TeamServiceResponse> findAllTeams() {
        return repository.findAll()
                .map(TeamServiceResponseMapper::toTeamServiceResponse);
    }

}
