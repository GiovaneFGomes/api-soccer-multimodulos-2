package com.giovane.soccer.controller.league;

import com.giovane.soccer.controller.model.request.LeagueControllerRequest;
import com.giovane.soccer.controller.model.response.LeagueControllerResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import javax.validation.Valid;
import static org.springframework.http.HttpStatus.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/soccer/league")
public class LeagueController {

    private final LeagueControllerFacade facade;

    @PostMapping
    @ResponseStatus(CREATED)
    public Mono<LeagueControllerResponse> save(@RequestBody @Valid LeagueControllerRequest leagueControllerRequest) {
        return facade.save(leagueControllerRequest);
    }

    @PutMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public Mono<LeagueControllerResponse> updateById(@RequestBody @Valid LeagueControllerRequest leagueControllerRequest,
                                                     @PathVariable("id") String id) {
        return facade.updateById(leagueControllerRequest, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public Mono<Void> deleteById(@PathVariable("id") String id) {
        return facade.deleteById(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    public Mono<LeagueControllerResponse> findById(@PathVariable("id") String id) {
        return facade.findById(id);
    }

    @GetMapping("/findAll")
    @ResponseStatus(OK)
    public Flux<LeagueControllerResponse> findAll() {
        return facade.findAll();
    }

}
