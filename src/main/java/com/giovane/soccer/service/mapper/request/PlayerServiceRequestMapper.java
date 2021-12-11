package com.giovane.soccer.service.mapper.request;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import com.giovane.soccer.entity.player.Player;
import com.giovane.soccer.service.model.request.PlayerServiceRequest;

@Mapper
public interface PlayerServiceRequestMapper {

    static Player toPlayerEntity(PlayerServiceRequest playerRequest){
        return Mappers.getMapper(PlayerServiceRequestMapper.class)
                .mapper(playerRequest);
    }

    Player mapper(PlayerServiceRequest playerRequest);

}

