package com.giovane.soccer.service.player;

import com.giovane.soccer.service.mapper.request.PlayerServiceRequestMapper;
import com.giovane.soccer.service.mapper.response.PlayerServiceResponseMapper;
import com.giovane.soccer.service.model.request.PlayerServiceRequest;
import com.giovane.soccer.service.model.response.PlayerServiceResponse;
import lombok.*;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.springframework.stereotype.*;
import com.giovane.soccer.entity.player.Player;
import com.giovane.soccer.repository.player.PlayerRepository;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@AllArgsConstructor
@Service
public class PlayerService {

    private final PlayerRepository repository;

    public Mono<PlayerServiceResponse> save(PlayerServiceRequest playerRequest) {
        Player playerEntity = PlayerServiceRequestMapper.toPlayerEntity(playerRequest);
        Mono<Player> playerResponse = repository.save(playerEntity);
        return playerResponse.map(PlayerServiceResponseMapper::toPlayerServiceResponse);
    }

    public Mono<PlayerServiceResponse> update(PlayerServiceRequest playerRequest, String id) {
        playerRequest.setId(id);
        Player playerEntity = PlayerServiceRequestMapper.toPlayerEntity(playerRequest);
        Mono<Player> playerResponse = repository.save(playerEntity);
        return playerResponse.map(PlayerServiceResponseMapper::toPlayerServiceResponse);
    }

    public Mono<Void> delete(String id) {
        return repository.deleteById(id);
    }

    public Mono<PlayerServiceResponse> findById(String id) {
        Mono<Player> playerResponse = repository.findById(id)
                .switchIfEmpty(Mono.error(() -> new ResponseStatusException(NOT_FOUND, "ID not found")));
        return playerResponse.map(PlayerServiceResponseMapper::toPlayerServiceResponse);
    }

    public Flux<PlayerServiceResponse> findAll() {
        return repository.findAll()
                .map(PlayerServiceResponseMapper::toPlayerServiceResponse);
    }

}
