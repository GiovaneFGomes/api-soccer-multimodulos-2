package com.giovane.soccer.controller.mapper.response;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import com.giovane.soccer.service.model.response.PlayerServiceResponse;
import com.giovane.soccer.controller.model.response.PlayerControllerResponse;

@Mapper
public interface PlayerControllerResponseMapper {

    static PlayerControllerResponse toPlayerControllerResponse(PlayerServiceResponse playerResponse){
        return Mappers.getMapper(PlayerControllerResponseMapper.class)
                .mapper(playerResponse);
    }

    PlayerControllerResponse mapper(PlayerServiceResponse playerResponse);

}
