package com.giovane.soccer.controller.mapper.request;

import com.giovane.soccer.controller.model.request.PlayerControllerRequest;
import com.giovane.soccer.entity.player.Player;

public interface PlayerControllerRequestMapper {

    static Player toPlayerEntityWithoutId(PlayerControllerRequest playerControllerRequest) {

        return Player.builder()
                .name(playerControllerRequest.getName())
                .icon(playerControllerRequest.getIcon())
                .bio(playerControllerRequest.getBio())
                .age(playerControllerRequest.getAge())
                .number(playerControllerRequest.getNumber())
                .position(playerControllerRequest.getPosition())
                .height(playerControllerRequest.getHeight())
                .nationality(playerControllerRequest.getNationality())
                .currentTeam(playerControllerRequest.getCurrentTeam())
                .build();
    }

    static Player toPlayerEntityWithId(PlayerControllerRequest playerControllerRequest, String id) {

        return Player.builder()
                .id(id)
                .name(playerControllerRequest.getName())
                .icon(playerControllerRequest.getIcon())
                .bio(playerControllerRequest.getBio())
                .age(playerControllerRequest.getAge())
                .number(playerControllerRequest.getNumber())
                .position(playerControllerRequest.getPosition())
                .height(playerControllerRequest.getHeight())
                .nationality(playerControllerRequest.getNationality())
                .currentTeam(playerControllerRequest.getCurrentTeam())
                .build();
    }

}
