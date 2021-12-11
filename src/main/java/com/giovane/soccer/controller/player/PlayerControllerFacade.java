package com.giovane.soccer.controller.player;

import com.giovane.soccer.controller.mapper.request.PlayerControllerRequestMapper;
import com.giovane.soccer.controller.mapper.response.PlayerControllerResponseMapper;
import lombok.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.springframework.stereotype.*;
import com.giovane.soccer.service.player.PlayerFacade;
import com.giovane.soccer.service.model.request.PlayerServiceRequest;
import com.giovane.soccer.service.model.response.PlayerServiceResponse;
import com.giovane.soccer.controller.model.request.PlayerControllerRequest;
import com.giovane.soccer.controller.model.response.PlayerControllerResponse;

@AllArgsConstructor
@Component
public class PlayerControllerFacade {

    private final PlayerFacade facade;

    public Mono<PlayerControllerResponse> savePlayer(PlayerControllerRequest playerRequest) {
        PlayerServiceRequest playerService = PlayerControllerRequestMapper.toPlayerService(playerRequest);
        Mono<PlayerServiceResponse> playerServiceResponseMono = facade.savePlayer(playerService);
        return playerServiceResponseMono.map(PlayerControllerResponseMapper::toPlayerControllerResponse);
    }

    public Mono<PlayerControllerResponse> updatePlayerById(PlayerControllerRequest playerRequest, String id) {
        PlayerServiceRequest playerService = PlayerControllerRequestMapper.toPlayerService(playerRequest);
        Mono<PlayerServiceResponse> playerServiceResponseMono = facade.updatePlayerById(playerService, id);
        return playerServiceResponseMono.map(PlayerControllerResponseMapper::toPlayerControllerResponse);
    }

    public Mono<Void> deletePlayerById(String id) {
        return facade.deletePlayerById(id);
    }

    public Mono<PlayerControllerResponse> findPlayerById(String id) {
        Mono<PlayerServiceResponse> playerServiceResponseMono = facade.findPlayerById(id);
        return playerServiceResponseMono.map(PlayerControllerResponseMapper::toPlayerControllerResponse);
    }

    public Flux<PlayerControllerResponse> findAllPlayers() {
        return facade.findAllPlayers()
                .map(PlayerControllerResponseMapper::toPlayerControllerResponse);
    }

}
