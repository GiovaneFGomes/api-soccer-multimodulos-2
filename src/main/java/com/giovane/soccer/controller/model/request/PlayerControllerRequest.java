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
    @Size(max = 60, message = "Max 60 characters.")
    private String name;

    @NotBlank(message = "Icon should not be blank.")
    private String icon;

    @NotBlank(message = "Bio should not be blank.")
    @Size(max = 500, message = "Max 500 characters.")
    private String bio;

    @NotEmpty(message = "Age should not be empty.")
    private Integer age;

    // Coloquei @NotBlank, pois se o player não tiver time
    // tambem nao tera numero. Aí se nao tiver time colocar ---
    @NotBlank(message = "Number should not be empty.")
    private Integer number;

    @NotEmpty(message = "Position should not be empty.")
    private Position position;

    @NotEmpty(message = "Height should not be empty.")
    private Double height;

    @NotBlank(message = "Nationality should not be blank.")
    @Size(max = 25, message = "Max 25 characters.")
    private String nationality;

    @NotBlank(message = "Current team should not be blank.")
    private Team currentTeam;
}
