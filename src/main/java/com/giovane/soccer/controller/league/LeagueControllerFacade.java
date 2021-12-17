package com.giovane.soccer.controller.league;

import com.giovane.soccer.controller.mapper.response.LeagueControllerResponseMapper;
import com.giovane.soccer.controller.model.request.LeagueControllerRequest;
import com.giovane.soccer.controller.model.response.LeagueControllerResponse;
import com.giovane.soccer.service.league.LeagueFacade;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import static com.giovane.soccer.controller.mapper.request.LeagueControllerRequestMapper.toLeagueServiceRequest;

@AllArgsConstructor
@Component
public class LeagueControllerFacade {

    private final LeagueFacade facade;

    public Mono<LeagueControllerResponse> save(LeagueControllerRequest leagueControllerRequest) {
        return facade.save(toLeagueServiceRequest(leagueControllerRequest))
                .map(LeagueControllerResponseMapper::toLeagueControllerResponse);
    }

    public Mono<LeagueControllerResponse> updateById(LeagueControllerRequest leagueControllerRequest, String id) {
        return facade.updateById(toLeagueServiceRequest(leagueControllerRequest), id)
                .map(LeagueControllerResponseMapper::toLeagueControllerResponse);
    }

    public Mono<Void> deleteById(String id) {
        return facade.deleteById(id);
    }

    public Mono<LeagueControllerResponse> findById(String id) {
        return facade.findById(id)
                .map(LeagueControllerResponseMapper::toLeagueControllerResponse);
    }

    public Flux<LeagueControllerResponse> findAll() {
        return facade.findAll()
                .map(LeagueControllerResponseMapper::toLeagueControllerResponse);
    }

}
