package com.giovane.soccer.controller.mapper.request;

import com.giovane.soccer.controller.model.request.PlayerControllerRequest;
import com.giovane.soccer.service.model.request.PlayerServiceRequest;

public interface PlayerControllerRequestMapper {

    static PlayerServiceRequest toPlayerServiceRequest(PlayerControllerRequest playerControllerRequest) {
        if (playerControllerRequest == null) {
            return null;
        }

        return PlayerServiceRequest.builder()
                .id(playerControllerRequest.getId())
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
