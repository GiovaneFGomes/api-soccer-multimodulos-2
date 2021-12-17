package com.giovane.soccer.controller.model.request;

import com.giovane.soccer.entity.team.Team;
import com.giovane.soccer.commons.Position;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

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

    private Integer age;
    private Team actualTeam;
    private Integer number;
    private Position position;
    private Double height;
}
