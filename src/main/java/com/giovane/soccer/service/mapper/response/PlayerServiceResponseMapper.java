package com.giovane.soccer.service.mapper.response;

import com.giovane.soccer.entity.player.Player;
import com.giovane.soccer.service.model.response.PlayerServiceResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PlayerServiceResponseMapper {

    static PlayerServiceResponse toPlayerServiceResponse(Player player){
        return Mappers.getMapper(PlayerServiceResponseMapper.class)
                .mapper(player);
    }

    PlayerServiceResponse mapper(Player player);

}
