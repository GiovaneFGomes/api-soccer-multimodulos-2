package com.giovane.soccer.service.player;

import com.giovane.soccer.service.mapper.response.PlayerServiceResponseMapper;
import com.giovane.soccer.service.model.request.PlayerServiceRequest;
import com.giovane.soccer.service.model.response.PlayerServiceResponse;
import lombok.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.springframework.stereotype.*;
import com.giovane.soccer.repository.player.PlayerRepository;
import org.springframework.web.server.ResponseStatusException;
import static com.giovane.soccer.service.mapper.request.PlayerServiceRequestMapper.toPlayerEntity;
import static org.springframework.http.HttpStatus.*;

@AllArgsConstructor
@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    public Mono<PlayerServiceResponse> save(PlayerServiceRequest playerServiceRequest) {
        return playerRepository.save(toPlayerEntity(playerServiceRequest))
                .map(PlayerServiceResponseMapper::toPlayerServiceResponse); // TODO debugar com evaluate pra ver se vem o id
    }

    public Mono<Void> deleteById(String id) {
        return playerRepository.deleteById(id);
    }

    public Mono<PlayerServiceResponse> findById(String id) {
        return playerRepository.findById(id)
                .switchIfEmpty(Mono.error(() -> new ResponseStatusException(NOT_FOUND, "ID not found")))
                .map(PlayerServiceResponseMapper::toPlayerServiceResponse);
    }

    public Flux<PlayerServiceResponse> findAll() {
        return playerRepository.findAll()
                .map(PlayerServiceResponseMapper::toPlayerServiceResponse);
    }

}
