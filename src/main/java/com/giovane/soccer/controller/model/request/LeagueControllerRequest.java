package com.giovane.soccer.controller.model.request;

import com.giovane.soccer.entity.team.Team;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class LeagueControllerRequest {
    private String id;

    @NotBlank
    @Size(min = 1, max = 100, message = "Min 1 and Max 100 characters.")
    private String nationality;

    @NotBlank
    @Size(min = 1, max = 100, message = "Min 1 and Max 100 characters.")
    private String name;

    @NotBlank
    @Size(min = 1, max = 100, message = "Min 1 and Max 100 characters.")
    private String type;

    private String icon;
    private List<Team> teams;
}
