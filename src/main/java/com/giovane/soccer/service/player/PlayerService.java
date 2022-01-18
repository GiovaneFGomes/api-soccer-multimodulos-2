package com.giovane.soccer.service.player;

import com.giovane.soccer.entity.player.Player;
import lombok.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.springframework.stereotype.*;
import com.giovane.soccer.repository.player.PlayerRepository;
import org.springframework.web.server.ResponseStatusException;
import static org.springframework.http.HttpStatus.*;

@AllArgsConstructor
@Service
public class PlayerService {

    private final PlayerRepository repository;

    public Mono<Player> save(Player player) {
        return repository.save(player);
    }

    public Mono<Player> update(Player player) {
        return repository.save(player);
    }

    public Mono<Void> deleteById(String id) {
        return repository.deleteById(id);
    }

    public Mono<Player> findById(String id) {
        return repository.findById(id)
                .switchIfEmpty(Mono.error(() -> new ResponseStatusException(NOT_FOUND, "ID not found")));
    }

    public Flux<Player> findAll() {
        return repository.findAll();
    }

}
