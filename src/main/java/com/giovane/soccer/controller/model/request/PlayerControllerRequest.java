package com.giovane.soccer.controller.model.request;

import lombok.*;
import javax.validation.constraints.*;
import com.giovane.soccer.entity.team.Team;
import com.giovane.soccer.commons.Position;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class PlayerControllerRequest {
    private String id;

    @NotBlank
    @Size(min = 1, max = 100, message = "Min 1 and Max 100 characters.")
    private String name;

    @NotBlank
    @Size(min = 1, max = 100, message = "Min 1 and Max 100 characters.")
    private String nationality;

    @NotNull
    private Integer age;

    private Team actualTeam;

    @NotNull
    private Integer number;

    private Position position;

    @NotNull
    private Double height;
}
