package com.giovane.soccer.service.mapper.request;

import com.giovane.soccer.entity.player.Player;
import com.giovane.soccer.service.model.request.PlayerServiceRequest;

public interface PlayerServiceRequestMapper {

    static Player toPlayerEntity(PlayerServiceRequest playerRequest) {
        if (playerRequest == null) {
            return null;
        }

        return Player.builder()
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
