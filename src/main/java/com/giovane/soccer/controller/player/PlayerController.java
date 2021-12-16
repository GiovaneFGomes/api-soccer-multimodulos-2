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
    public Mono<PlayerControllerResponse> save(@RequestBody @Valid PlayerControllerRequest playerRequest) {
        return facade.save(playerRequest);
    }

    @ResponseStatus(NO_CONTENT)
    @PutMapping("/{id}")
    public Mono<PlayerControllerResponse> update(@RequestBody @Valid PlayerControllerRequest playerRequest, @PathVariable("id") String id) {
        return facade.update(playerRequest, id);
    }

    @ResponseStatus(NO_CONTENT)
    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable("id") String id) {
        return facade.delete(id);
    }

    @ResponseStatus(OK)
    @GetMapping("/{id}")
    public Mono<PlayerControllerResponse> findById(@PathVariable("id") String id) {
        return facade.findById(id);
    }

    @ResponseStatus(OK)
    @GetMapping("/findAll")
    public Flux<PlayerControllerResponse> findAll() {
        return facade.findAll();
    }
}
