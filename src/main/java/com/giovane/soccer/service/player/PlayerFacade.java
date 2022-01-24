package com.giovane.soccer.service.player;

import com.giovane.soccer.service.model.request.PlayerServiceRequest;
import com.giovane.soccer.service.model.response.PlayerServiceResponse;
import lombok.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.springframework.stereotype.*;


@AllArgsConstructor
@Component
public class PlayerFacade {

    private final PlayerService playerService;

    public Mono<PlayerServiceResponse> save(PlayerServiceRequest playerServiceRequest) {
        return playerService.save(playerServiceRequest);
    }

    public Mono<PlayerServiceResponse> update(PlayerServiceRequest playerServiceRequest) {
        return playerService.findById(playerServiceRequest.getId())
                .flatMap(val -> playerService.save(playerServiceRequest));
    }

    public Mono<Void> deleteById(String id) {
        return playerService.findById(id)
                .flatMap(val -> playerService.deleteById(val.getId()));
    }

    public Mono<PlayerServiceResponse> findById(String id) {
        return playerService.findById(id);
    }

    public Flux<PlayerServiceResponse> findAll() {
        return playerService.findAll();
    }

}
