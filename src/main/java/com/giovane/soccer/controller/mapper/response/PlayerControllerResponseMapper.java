package com.giovane.soccer.controller.mapper.response;

import com.giovane.soccer.service.model.response.PlayerServiceResponse;
import com.giovane.soccer.controller.model.response.PlayerControllerResponse;

public interface PlayerControllerResponseMapper {

    static PlayerControllerResponse toPlayerControllerResponse(PlayerServiceResponse playerResponse) {
        if (playerResponse == null) {
            return null;
        }

        return PlayerControllerResponse.builder()
                .id(playerResponse.getId())
                .name(playerResponse.getName())
                .icon(playerResponse.getIcon())
                .bio(playerResponse.getBio())
                .age(playerResponse.getAge())
                .number(playerResponse.getNumber())
                .position(playerResponse.getPosition())
                .height(playerResponse.getHeight())
                .nationality(playerResponse.getNationality())
                .currentTeam(playerResponse.getCurrentTeam())
                .build();
    }

}
