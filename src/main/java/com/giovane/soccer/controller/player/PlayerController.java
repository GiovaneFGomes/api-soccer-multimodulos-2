package com.giovane.soccer.controller.player;

import lombok.*;
import javax.validation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.springframework.web.bind.annotation.*;
import static org.springframework.http.HttpStatus.*;
import com.giovane.soccer.controller.model.request.PlayerControllerRequest;
import com.giovane.soccer.controller.model.response.PlayerControllerResponse;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/soccer/player")
public class PlayerController {

    private final PlayerControllerFacade facade;

    @ResponseStatus(CREATED)
    @PostMapping
    public Mono<PlayerControllerResponse> savePlayer(@RequestBody @Valid PlayerControllerRequest playerRequest) {
        return facade.savePlayer(playerRequest);
    }

    @ResponseStatus(NO_CONTENT)
    @PutMapping("/{id}")
    public Mono<PlayerControllerResponse> updatePlayerById(@RequestBody @Valid PlayerControllerRequest playerRequest, @PathVariable("id") String id) {
        return facade.updatePlayerById(playerRequest, id);
    }

    @ResponseStatus(NO_CONTENT)
    @DeleteMapping("/{id}")
    public Mono<Void> deletePlayerById(@PathVariable("id") String id) {
        return facade.deletePlayerById(id);
    }

    @ResponseStatus(OK)
    @GetMapping("/{id}")
    public Mono<PlayerControllerResponse> findPlayerById(@PathVariable("id") String id) {
        return facade.findPlayerById(id);
    }

    @ResponseStatus(OK)
    @GetMapping("/findAll")
    public Flux<PlayerControllerResponse> findAllPlayers() {
        return facade.findAllPlayers();
    }
}
