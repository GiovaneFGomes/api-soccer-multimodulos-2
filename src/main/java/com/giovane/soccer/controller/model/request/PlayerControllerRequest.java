package com.giovane.soccer.controller.model.request;

import lombok.*;
import com.giovane.soccer.entity.team.Team;
import com.giovane.soccer.commons.Position;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class PlayerControllerRequest {

    private String id;

    @NotBlank(message = "Name should not be blank.")
    @Size(min = 2, max = 60, message = "Min 2 and Max 60 characters.")
    private String name;

    @NotBlank(message = "Icon should not be blank.")
    private String icon;

    @NotBlank(message = "Bio should not be blank.")
    @Size(min = 50, max = 500, message = "Min 50 and Max 500 characters.")
    private String bio;

    @NotEmpty(message = "Age should not be empty.")
    private Integer age;

    // coloquei @NotBlank, pois se o player não tiver time
    // tambem nao tera numero. Aí se nao tiver time colocar ---
    @NotBlank(message = "Number should not be empty.")
    private Integer number;

    @NotEmpty(message = "Position should not be empty.")
    private Position position;

    @NotEmpty(message = "Height should not be empty.")
    private Double height;

    @NotBlank(message = "Nationality should not be blank.")
    @Size(min = 4, max = 25, message = "Min 4 and Max 25 characters.")
    private String nationality;

    @NotBlank(message = "Current team should not be empty.")
    private Team currentTeam;
}
