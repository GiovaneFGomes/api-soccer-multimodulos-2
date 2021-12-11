package com.giovane.soccer.controller.mapper.request;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import com.giovane.soccer.service.model.request.PlayerServiceRequest;
import com.giovane.soccer.controller.model.request.PlayerControllerRequest;

@Mapper
public interface PlayerControllerRequestMapper {

    static PlayerServiceRequest toPlayerService(PlayerControllerRequest playerRequest){
        return Mappers.getMapper(PlayerControllerRequestMapper.class)
                .mapper(playerRequest);
    }

    PlayerServiceRequest mapper(PlayerControllerRequest playerRequest);

}
