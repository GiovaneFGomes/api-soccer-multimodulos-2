package com.giovane.soccer.controller.player;

import lombok.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.springframework.stereotype.*;
import com.giovane.soccer.service.player.PlayerFacade;
import com.giovane.soccer.controller.model.request.PlayerControllerRequest;
import com.giovane.soccer.controller.model.response.PlayerControllerResponse;
import com.giovane.soccer.controller.mapper.response.PlayerControllerResponseMapper;
import static com.giovane.soccer.controller.mapper.request.PlayerControllerRequestMapper.toPlayerServiceRequest;

@AllArgsConstructor
@Component
public class PlayerControllerFacade {

    private final PlayerFacade facade;

    public Mono<PlayerControllerResponse> save(PlayerControllerRequest playerControllerRequest) {
        return facade.save(toPlayerServiceRequest(playerControllerRequest))
                .map(PlayerControllerResponseMapper::toPlayerControllerResponse);
    }

    public Mono<PlayerControllerResponse> updateById(PlayerControllerRequest playerControllerRequest, String id) {
        return facade.updateById(toPlayerServiceRequest(playerControllerRequest), id)
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
