package com.giovane.soccer.service.league;

import com.giovane.soccer.service.model.request.LeagueServiceRequest;
import com.giovane.soccer.service.model.response.LeagueServiceResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Component
public class LeagueFacade {

    private final LeagueService service;

    public Mono<LeagueServiceResponse> save(LeagueServiceRequest leagueServiceRequest) {
        return service.save(leagueServiceRequest);
    }

    public Mono<LeagueServiceResponse> updateById(LeagueServiceRequest leagueServiceRequest, String id) {
        return service.findById(id)
                .flatMap(val -> service.updateById(leagueServiceRequest, val.getId()));
    }

    public Mono<Void> deleteById(String id) {
        return service.findById(id)
                .flatMap(val -> service.deleteById(val.getId()));
    }

    public Mono<LeagueServiceResponse> findById(String id) {
        return service.findById(id);
    }

    public Flux<LeagueServiceResponse> findAll() {
        return service.findAll();
    }

}
