package com.giovane.soccer.service.mapper;

import com.giovane.soccer.entity.player.Player;
import com.giovane.soccer.entity.team.Team;
import java.util.List;

public class TeamModelMapper {

    public static Team mapper(Team teamInitialState, Team responseService) {
        teamInitialState.setName(responseService.getName());
        return teamInitialState;
    }

    public static Team addPlayer(Team teamInitialState, List<Player> player) {
        teamInitialState.setPlayer(player);
        return teamInitialState;
    }

}
