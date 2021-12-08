package com.giovane.soccer.service.v1;

import com.giovane.soccer.entity.Team;
import com.giovane.soccer.repository.TeamRepository;
import com.giovane.soccer.service.mapper.response.TeamServiceResponseMapper;
import com.giovane.soccer.service.model.request.TeamServiceRequest;
import com.giovane.soccer.service.model.response.TeamServiceResponse;
import lombok.AllArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import static com.giovane.soccer.service.mapper.request.TeamServiceRequestMapper.toTeamEntity;
import static com.giovane.soccer.service.mapper.response.TeamServiceResponseMapper.toTeamServiceResponse;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@AllArgsConstructor
@Service
public class TeamService {

    private final TeamRepository repository;

    public Mono<TeamServiceResponse> saveTeam(TeamServiceRequest team) {
        Team teamSave = toTeamEntity(team);
        Mono<Team> teamResponse = repository.save(teamSave);
        return teamResponse.map(TeamServiceResponseMapper::toTeamServiceResponse);
    }

    public Mono<TeamServiceResponse> updateTeamById(TeamServiceRequest team, String id) {
        team.setId(id);
        Team teamSave = toTeamEntity(team);
        Mono<Team> teamResponse = repository.save(teamSave);
        return teamResponse.map(TeamServiceResponseMapper::toTeamServiceResponse);
    }

    public Mono<Void> deleteTeamById(String id) {
       return repository.deleteById(id);
    }

    public Mono<TeamServiceResponse> findTeamById(String id) {
        Mono<Team> teamResponse = repository.findById(id)
                .switchIfEmpty(Mono.error(new ResponseStatusException(NOT_FOUND, "ID not found")));
        return teamResponse.map(TeamServiceResponseMapper::toTeamServiceResponse);
    }

    public Flux<TeamServiceResponse> findAllTeams() {
        return repository.findAll()
                .map(TeamServiceResponseMapper::toTeamServiceResponse);
    }

}
