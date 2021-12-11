package com.giovane.soccer.service.v2.player;

import lombok.*;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.springframework.stereotype.*;
import com.giovane.soccer.entity.player.Player;
import com.giovane.soccer.repository.player.PlayerRepository;
import com.giovane.soccer.service.v2.model.request.PlayerServiceRequest;
import com.giovane.soccer.service.v2.model.response.PlayerServiceResponse;
import com.giovane.soccer.service.v2.mapper.response.PlayerServiceResponseMapper;
import static com.giovane.soccer.service.v2.mapper.request.PlayerServiceRequestMapper.toPlayerEntity;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@AllArgsConstructor
@Service
public class PlayerService {

    private final PlayerRepository repository;

    public Mono<PlayerServiceResponse> savePlayer(PlayerServiceRequest playerRequest) {
        Player playerEntity = toPlayerEntity(playerRequest);
        Mono<Player> playerResponse = repository.save(playerEntity);
        return playerResponse.map(PlayerServiceResponseMapper::toPlayerServiceResponse);
    }

    public Mono<PlayerServiceResponse> updatePlayerById(PlayerServiceRequest playerRequest, String id) {
        playerRequest.setId(id);
        Player playerEntity = toPlayerEntity(playerRequest);
        Mono<Player> playerResponse = repository.save(playerEntity);
        return playerResponse.map(PlayerServiceResponseMapper::toPlayerServiceResponse);
    }

    public Mono<Void> deletePlayerById(String id) {
        return repository.deleteById(id);
    }

    public Mono<PlayerServiceResponse> findPlayerById(String id) {
        Mono<Player> playerResponse = repository.findById(id)
                .switchIfEmpty(Mono.error(() -> new ResponseStatusException(NOT_FOUND, "ID not found")));
        return playerResponse.map(PlayerServiceResponseMapper::toPlayerServiceResponse);
    }

    public Flux<PlayerServiceResponse> findAllPlayers() {
        return repository.findAll()
                .map(PlayerServiceResponseMapper::toPlayerServiceResponse);
    }

}
