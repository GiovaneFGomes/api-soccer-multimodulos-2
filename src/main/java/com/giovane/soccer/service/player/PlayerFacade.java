package com.giovane.soccer.service.player;

import lombok.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.springframework.stereotype.*;
import com.giovane.soccer.service.model.request.PlayerServiceRequest;
import com.giovane.soccer.service.model.response.PlayerServiceResponse;

@AllArgsConstructor
@Component
public class PlayerFacade {

    private final PlayerService service;

    public Mono<PlayerServiceResponse> save(PlayerServiceRequest playerServiceResponse) {
        return service.save(playerServiceResponse);
    }

    public Mono<PlayerServiceResponse> updateById(PlayerServiceRequest playerServiceResponse, String id) {
        return service.findById(id)
                .flatMap(val -> service.updateById(playerServiceResponse, val.getId()));
    }

    public Mono<Void> deleteById(String id) {
        return service.findById(id)
                .flatMap(val -> service.deleteById(val.getId()));
    }

    public Mono<PlayerServiceResponse> findById(String id) {
        return service.findById(id);
    }

    public Flux<PlayerServiceResponse> findAll() {
        return service.findAll();
    }

}
