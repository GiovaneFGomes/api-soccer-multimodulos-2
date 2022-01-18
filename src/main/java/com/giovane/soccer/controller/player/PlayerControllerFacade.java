package com.giovane.soccer.controller.player;

import lombok.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.springframework.stereotype.*;
import com.giovane.soccer.service.player.PlayerFacade;
import com.giovane.soccer.controller.model.request.PlayerControllerRequest;
import com.giovane.soccer.controller.model.response.PlayerControllerResponse;
import com.giovane.soccer.controller.mapper.response.PlayerControllerResponseMapper;
import static com.giovane.soccer.controller.mapper.request.PlayerControllerRequestMapper.toPlayerEntityWithId;
import static com.giovane.soccer.controller.mapper.request.PlayerControllerRequestMapper.toPlayerEntityWithoutId;

@AllArgsConstructor
@Component
public class PlayerControllerFacade {

    private final PlayerFacade facade;

    public Mono<PlayerControllerResponse> save(PlayerControllerRequest playerControllerRequest) {
        return facade.save(toPlayerEntityWithoutId(playerControllerRequest))
                .map(PlayerControllerResponseMapper::toPlayerControllerResponse);
    }

    public Mono<PlayerControllerResponse> update(PlayerControllerRequest playerControllerRequest, String id) {
        return facade.update(toPlayerEntityWithId(playerControllerRequest, id))
                .map(PlayerControllerResponseMapper::toPlayerControllerResponse);
    }

    public Mono<Void> deleteById(String id) {
        return facade.deleteById(id);
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
