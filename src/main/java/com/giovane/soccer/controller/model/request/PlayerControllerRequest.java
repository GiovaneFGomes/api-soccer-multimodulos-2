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

    private Integer age;

    private Integer number;

    private Position position;

    private Double height;

    @NotBlank(message = "Nationality should not be blank.")
    @Size(max = 25, message = "Max 25 characters.")
    private String nationality;

    private Team currentTeam;
}
