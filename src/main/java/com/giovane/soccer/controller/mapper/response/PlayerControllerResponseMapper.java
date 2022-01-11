package com.giovane.soccer.controller.mapper.response;

import com.giovane.soccer.service.model.response.PlayerServiceResponse;
import com.giovane.soccer.controller.model.response.PlayerControllerResponse;

public interface PlayerControllerResponseMapper {

    static PlayerControllerResponse toPlayerControllerResponse(PlayerServiceResponse playerServiceResponse) {
        if (playerServiceResponse == null) {
            return null;
        }

        return PlayerControllerResponse.builder()
                .id(playerServiceResponse.getId())
                .name(playerServiceResponse.getName())
                .icon(playerServiceResponse.getIcon())
                .bio(playerServiceResponse.getBio())
                .age(playerServiceResponse.getAge())
                .number(playerServiceResponse.getNumber())
                .position(playerServiceResponse.getPosition())
                .height(playerServiceResponse.getHeight())
                .nationality(playerServiceResponse.getNationality())
                .currentTeam(playerServiceResponse.getCurrentTeam())
                .build();
    }

}
