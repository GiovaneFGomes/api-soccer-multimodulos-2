package com.giovane.soccer.controller.mapper.response;

import com.giovane.soccer.entity.player.Player;
import com.giovane.soccer.controller.model.response.PlayerControllerResponse;

public class PlayerControllerResponseMapper {

    public static PlayerControllerResponse toPlayerControllerResponse(Player player) {

        return PlayerControllerResponse.builder()
                .id(player.getId())
                .name(player.getName())
                .icon(player.getIcon())
                .bio(player.getBio())
                .age(player.getAge())
                .number(player.getNumber())
                .position(player.getPosition())
                .height(player.getHeight())
                .nationality(player.getNationality())
                .currentTeam(player.getCurrentTeam())
                .build();
    }

}
