package com.giovane.soccer.service.mapper.request;

import com.giovane.soccer.entity.player.Player;
import com.giovane.soccer.service.model.request.PlayerServiceRequest;

public interface PlayerServiceRequestMapper {

    static Player toPlayerEntity(PlayerServiceRequest playerServiceRequest) {
        if (playerServiceRequest == null) {
            return null;
        }

        return Player.builder()
                .id(playerServiceRequest.getId())
                .name(playerServiceRequest.getName())
                .icon(playerServiceRequest.getIcon())
                .bio(playerServiceRequest.getBio())
                .age(playerServiceRequest.getAge())
                .number(playerServiceRequest.getNumber())
                .position(playerServiceRequest.getPosition())
                .height(playerServiceRequest.getHeight())
                .nationality(playerServiceRequest.getNationality())
                .currentTeam(playerServiceRequest.getCurrentTeam())
                .build();
    }

}
