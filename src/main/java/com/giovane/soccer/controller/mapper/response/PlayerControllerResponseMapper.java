package com.giovane.soccer.controller.mapper.response;

import com.giovane.soccer.controller.model.response.PlayerControllerResponse;
import com.giovane.soccer.service.model.response.PlayerServiceResponse;

public class PlayerControllerResponseMapper {

    public static PlayerControllerResponse toPlayerControllerResponse(PlayerServiceResponse playerServiceRequest) {

        return PlayerControllerResponse.builder()
                .id(playerServiceRequest.getId())
                .name(playerServiceRequest.getName())
                .icon(playerServiceRequest.getIcon())
                .bio(playerServiceRequest.getBio())
                .age(playerServiceRequest.getAge())
                .number(playerServiceRequest.getNumber())
                .position(playerServiceRequest.getPosition())
                .height(playerServiceRequest.getHeight())
                .nationality(playerServiceRequest.getNationality())
                .build();
    }

}
