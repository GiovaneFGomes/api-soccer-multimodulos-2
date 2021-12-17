package com.giovane.soccer.controller.mapper.request;

import com.giovane.soccer.controller.model.request.PlayerControllerRequest;
import com.giovane.soccer.service.model.request.PlayerServiceRequest;

public interface PlayerControllerRequestMapper {

    static PlayerServiceRequest toPlayerServiceRequest(PlayerControllerRequest playerRequest) {
        if (playerRequest == null) {
            return null;
        }

        return PlayerServiceRequest.builder()
                .id(playerRequest.getId())
                .name(playerRequest.getName())
                .age(playerRequest.getAge())
                .nationality(playerRequest.getNationality())
                .actualTeam(playerRequest.getActualTeam())
                .number(playerRequest.getNumber())
                .position(playerRequest.getPosition())
                .height(playerRequest.getHeight())
                .build();
    }

}
