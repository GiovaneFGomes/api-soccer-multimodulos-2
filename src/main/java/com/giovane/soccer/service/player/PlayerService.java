package com.giovane.soccer.service.player;

import lombok.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.springframework.stereotype.*;
import com.giovane.soccer.repository.player.PlayerRepository;
import org.springframework.web.server.ResponseStatusException;
import com.giovane.soccer.service.model.request.PlayerServiceRequest;
import com.giovane.soccer.service.model.response.PlayerServiceResponse;
import com.giovane.soccer.service.mapper.response.PlayerServiceResponseMapper;
import static org.springframework.http.HttpStatus.*;
import static com.giovane.soccer.service.mapper.request.PlayerServiceRequestMapper.toPlayerEntity;

@AllArgsConstructor
@Service
public class PlayerService {

    private final PlayerRepository repository;

    public Mono<PlayerServiceResponse> save(PlayerServiceRequest playerServiceRequest) {
        return repository.save(toPlayerEntity(playerServiceRequest))
                .map(PlayerServiceResponseMapper::toPlayerServiceResponse);
    }

    public Mono<PlayerServiceResponse> updateById(PlayerServiceRequest playerServiceRequest, String id) {
        playerServiceRequest.setId(id); // TODO arrumar set pra controller
        return repository.save(toPlayerEntity(playerServiceRequest))
                .map(PlayerServiceResponseMapper::toPlayerServiceResponse);
    }

    public Mono<Void> deleteById(String id) {
        return repository.deleteById(id);
    }

    public Mono<PlayerServiceResponse> findById(String id) {
        return repository.findById(id)
                .switchIfEmpty(Mono.error(() -> new ResponseStatusException(NOT_FOUND, "ID not found")))
                .map(PlayerServiceResponseMapper::toPlayerServiceResponse);
    }

    public Flux<PlayerServiceResponse> findAll() {
        return repository.findAll()
                .map(PlayerServiceResponseMapper::toPlayerServiceResponse);
    }

}
