package com.giovane.soccer.controller.v1;

import com.giovane.soccer.controller.model.request.TeamControllerRequest;
import com.giovane.soccer.controller.model.response.TeamControllerResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import javax.validation.Valid;
import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.HttpStatus.OK;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/v1/soccer/team")
public class TeamController {

    private final TeamControllerFacade facade;

    @ResponseStatus(CREATED)
    @PostMapping
    public Mono<TeamControllerResponse> saveTeam(@RequestBody @Valid TeamControllerRequest teamRequest) {
        return facade.saveTeam(teamRequest);
    }

    @ResponseStatus(NOT_FOUND)
    @PutMapping("/{id}")
    public Mono<TeamControllerResponse> updateTeamById(@RequestBody @Valid TeamControllerRequest teamRequest, @PathVariable("id") String id) {
        return facade.updateTeamById(teamRequest, id);
    }

    @ResponseStatus(NO_CONTENT)
    @DeleteMapping("/{id}")
    public Mono<Void> deleteTeamById(@PathVariable("id") String id) {
       return facade.deleteTeamById(id);
    }

    @ResponseStatus(OK)
    @GetMapping("/{id}")
    public Mono<TeamControllerResponse> findTeamById(@PathVariable("id") String id) {
        return facade.findTeamById(id);
    }

    @ResponseStatus(OK)
    @GetMapping("/findAll")
    public Flux<TeamControllerResponse> findAllTeams() {
        return facade.findAllTeams();
    }

}
