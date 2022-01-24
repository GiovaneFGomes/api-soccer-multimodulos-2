package com.giovane.soccer.controller.mapper.request;

import com.giovane.soccer.controller.model.request.PlayerControllerRequest;
import com.giovane.soccer.service.model.request.PlayerServiceRequest;

public class PlayerControllerRequestMapper {

    public static PlayerServiceRequest toPlayerServiceWithId(PlayerControllerRequest playerControllerRequest, String id) {

        return PlayerServiceRequest.builder()
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

    public static PlayerServiceRequest toPlayerServiceWithoutId(PlayerControllerRequest playerControllerRequest) {

        return PlayerServiceRequest.builder()
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
