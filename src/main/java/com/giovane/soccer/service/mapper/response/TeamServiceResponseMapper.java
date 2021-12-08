package com.giovane.soccer.service.mapper.response;

import com.giovane.soccer.entity.Team;
import com.giovane.soccer.service.model.response.TeamServiceResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.BeanUtils;

@Mapper
public interface TeamServiceResponseMapper {

    static TeamServiceResponse toTeamServiceResponse(Team team){

        TeamServiceResponse productDto = new TeamServiceResponse();
        BeanUtils.copyProperties(team, productDto);
        return productDto;
    }

    public static Team dtoToEntity(TeamServiceResponse productDto) {

        Team product = new Team();
        BeanUtils.copyProperties(productDto, product);
        return product;

    }

    TeamServiceResponse mapper(Team team);

}
