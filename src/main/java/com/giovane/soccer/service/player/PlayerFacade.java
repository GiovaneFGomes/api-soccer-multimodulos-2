package com.giovane.soccer.service.player;

import com.giovane.soccer.service.model.request.PlayerServiceRequest;
import com.giovane.soccer.service.model.response.PlayerServiceResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Component
public class PlayerFacade {

    private final PlayerService service;

    public Mono<PlayerServiceResponse> savePlayer(PlayerServiceRequest playerResponse) {
        return service.savePlayer(playerResponse);
    }

    public Mono<PlayerServiceResponse> updatePlayerById(PlayerServiceRequest playerRequest,String id) {
        return service.findPlayerById(id)
                .flatMap(val -> service.updatePlayerById(playerRequest, val.getId()));
    }

    public Mono<Void> deletePlayerById(String id) {
        return service.findPlayerById(id)
                .flatMap(val -> service.deletePlayerById(val.getId()));
    }

    public Mono<PlayerServiceResponse> findPlayerById(String id) {
        return service.findPlayerById(id);
    }

    public Flux<PlayerServiceResponse> findAllPlayers() {
        return service.findAllPlayers();
    }

}
