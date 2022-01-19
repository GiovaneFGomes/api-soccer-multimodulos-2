package com.giovane.soccer.service.player;

import lombok.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.springframework.stereotype.*;
import com.giovane.soccer.entity.player.Player;


@AllArgsConstructor
@Component
public class PlayerFacade {

    private final PlayerService playerService;

    public Mono<Player> save(Player player) {
        return playerService.save(player);
    }

    public Mono<Player> update(Player player) {
        return playerService.findById(player.getId())
                .flatMap(val -> playerService.save(player));
    }

    public Mono<Void> deleteById(String id) {
        return playerService.findById(id)
                .flatMap(val -> playerService.deleteById(val.getId()));
    }

    public Mono<Player> findById(String id) {
        return playerService.findById(id);
    }

    public Flux<Player> findAll() {
        return playerService.findAll();
    }

}
