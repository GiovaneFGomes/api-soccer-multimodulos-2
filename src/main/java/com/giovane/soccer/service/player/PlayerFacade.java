package com.giovane.soccer.service.player;

import com.giovane.soccer.entity.player.Player;
import lombok.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.springframework.stereotype.*;

@AllArgsConstructor
@Component
public class PlayerFacade {

    private final PlayerService service;

    public Mono<Player> save(Player player) {
        return service.save(player);
    }

    public Mono<Player> update(Player player) {
        return service.findById(player.getId())
                .flatMap(val -> service.save(player));
    }

    public Mono<Void> deleteById(String id) {
        return service.findById(id)
                .flatMap(val -> service.deleteById(val.getId()));
    }

    public Mono<Player> findById(String id) {
        return service.findById(id);
    }

    public Flux<Player> findAll() {
        return service.findAll();
    }

}
