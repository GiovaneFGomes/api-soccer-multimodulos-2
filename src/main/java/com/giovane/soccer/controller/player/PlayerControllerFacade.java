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

import static com.giovane.soccer.controller.mapper.request.PlayerControllerRequestMapper.toPlayerService;

@AllArgsConstructor
@Component
public class PlayerControllerFacade {

    private final PlayerFacade facade;

    public Mono<PlayerControllerResponse> save(PlayerControllerRequest playerRequest) {
        return facade.save(toPlayerService(playerRequest))
                .map(PlayerControllerResponseMapper::toPlayerControllerResponse);
    }

    public Mono<PlayerControllerResponse> update(PlayerControllerRequest playerRequest, String id) {
        return facade.update( toPlayerService(playerRequest), id)
                .map(PlayerControllerResponseMapper::toPlayerControllerResponse);
    }

    public Mono<Void> delete(String id) {
        return facade.delete(id);
    }

    public Mono<PlayerControllerResponse> findById(String id) {
        return facade.findById(id)
                .map(PlayerControllerResponseMapper::toPlayerControllerResponse);
    }

    public Flux<PlayerControllerResponse> findAll() {
        return facade.findAll()
                .map(PlayerControllerResponseMapper::toPlayerControllerResponse);
    }

}
