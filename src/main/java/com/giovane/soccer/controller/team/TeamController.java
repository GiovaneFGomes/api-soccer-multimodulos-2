package com.giovane.soccer.controller.team;

import lombok.*;
import javax.validation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.springframework.web.bind.annotation.*;
import com.giovane.soccer.controller.model.request.TeamControllerRequest;
import com.giovane.soccer.controller.model.response.TeamControllerResponse;
import static org.springframework.http.HttpStatus.*;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/v1/soccer/team")
public class TeamController {

    private final TeamControllerFacade facade;

    @ResponseStatus(CREATED)
    @PostMapping
    public Mono<TeamControllerResponse> save(@RequestBody @Valid TeamControllerRequest teamControllerRequest) {
        return facade.save(teamControllerRequest);
    }

    @ResponseStatus(NO_CONTENT)
    @PutMapping("/{id}")
    public Mono<TeamControllerResponse> update(@RequestBody @Valid TeamControllerRequest teamControllerRequest
                                              ,@PathVariable String id) {
        return facade.update(teamControllerRequest, id);
    }

    @ResponseStatus(OK)
    @PatchMapping("/{id}/player/{playerId}")
    public Mono<TeamControllerResponse> addPlayer(@PathVariable String id, @PathVariable String playerId) {
        return facade.addPlayer(id, playerId);
    }

    @ResponseStatus(NO_CONTENT)
    @DeleteMapping("/{id}")
    public Mono<Void> deleteById(@PathVariable String id) {
       return facade.deleteById(id);
    }

    @ResponseStatus(OK)
    @GetMapping("/{id}")
    public Mono<TeamControllerResponse> findById(@PathVariable String id) {
        return facade.findById(id);
    }

    @ResponseStatus(OK)
    @GetMapping
    public Flux<TeamControllerResponse> findAll() {
        return facade.findAll();
    }

}
