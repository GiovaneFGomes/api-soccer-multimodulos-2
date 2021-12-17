package com.giovane.soccer.service.league;

import com.giovane.soccer.repository.league.LeagueRepository;
import com.giovane.soccer.service.mapper.response.LeagueServiceResponseMapper;
import com.giovane.soccer.service.model.request.LeagueServiceRequest;
import com.giovane.soccer.service.model.response.LeagueServiceResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import static com.giovane.soccer.service.mapper.request.LeagueServiceRequestMapper.toLeagueEntity;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@AllArgsConstructor
@Service
public class LeagueService {

    private final LeagueRepository repository;

    public Mono<LeagueServiceResponse> save(LeagueServiceRequest leagueServiceRequest) {
        return repository.save(toLeagueEntity(leagueServiceRequest))
                .map(LeagueServiceResponseMapper::toLeagueServiceResponse);
    }

    public Mono<LeagueServiceResponse> updateById(LeagueServiceRequest leagueServiceRequest, String id) {
        leagueServiceRequest.setId(id);
        return repository.save(toLeagueEntity(leagueServiceRequest))
                .map(LeagueServiceResponseMapper::toLeagueServiceResponse);
    }

    public Mono<Void> deleteById(String id) {
        return repository.deleteById(id);
    }

    public Mono<LeagueServiceResponse> findById(String id) {
        return repository.findById(id)
                .switchIfEmpty(Mono.error(new ResponseStatusException(NOT_FOUND, "ID not found")))
                .map(LeagueServiceResponseMapper::toLeagueServiceResponse);
    }

    public Flux<LeagueServiceResponse> findAll() {
        return repository.findAll()
                .map(LeagueServiceResponseMapper::toLeagueServiceResponse);
    }

}
