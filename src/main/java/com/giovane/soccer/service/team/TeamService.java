package com.giovane.soccer.service.team;

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

    public Mono<TeamServiceResponse> save(TeamServiceRequest teamServiceRequest) {
        return repository.save(toTeamEntity(teamServiceRequest))
                .map(TeamServiceResponseMapper::toTeamServiceResponse);
    }

    public Mono<TeamServiceResponse> updateById(TeamServiceRequest teamServiceRequest, String id) {
        teamServiceRequest.setId(id); // TODO arrumar set
        return repository.save(toTeamEntity(teamServiceRequest))
                .map(TeamServiceResponseMapper::toTeamServiceResponse);
    }

    // TODO fazer patch

    public Mono<Void> deleteById(String id) {
       return repository.deleteById(id);
    }

    public Mono<TeamServiceResponse> findById(String id) {
        return repository.findById(id)
                .switchIfEmpty(Mono.error(new ResponseStatusException(NOT_FOUND, "ID not found")))
                .map(TeamServiceResponseMapper::toTeamServiceResponse);
    }

    public Flux<TeamServiceResponse> findAll() {
        return repository.findAll()
                .map(TeamServiceResponseMapper::toTeamServiceResponse);
    }

}
