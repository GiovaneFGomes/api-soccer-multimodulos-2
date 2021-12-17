package com.giovane.soccer.service.mapper.response;

import com.giovane.soccer.entity.player.Player;
import com.giovane.soccer.service.model.response.PlayerServiceResponse;

public interface PlayerServiceResponseMapper {

    static PlayerServiceResponse toPlayerServiceResponse(Player player) {
        if (player == null) {
            return null;
        }

        return PlayerServiceResponse.builder()
                .id(player.getId())
                .name(player.getName())
                .age(player.getAge())
                .nationality(player.getNationality())
                .icon(player.getIcon())
                .bio(player.getBio())
                .actualTeam(player.getActualTeam())
                .number(player.getNumber())
                .position(player.getPosition())
                .height(player.getHeight())
                .build();
    }

}
