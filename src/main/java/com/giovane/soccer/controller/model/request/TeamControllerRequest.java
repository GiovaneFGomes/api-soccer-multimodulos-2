package com.giovane.soccer.controller.model.request;

import lombok.*;
import java.util.List;
import java.time.LocalDate;
import javax.validation.constraints.*;
import com.giovane.soccer.entity.player.Player;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class TeamControllerRequest {

    private String id;

    @NotBlank
    @Size(min = 3, max = 40, message = "Min 3 and Max 40 characters.")
    private String name;

    @NotBlank
    @Size(min = 3, max = 40, message = "Min 3 and Max 40 characters.")
    private String stadium;

    @NotBlank
    @Size(min = 3, max = 40, message = "Min 3 and Max 40 characters.")
    private String country;

    private List<Player> player;

    private LocalDate date;

}
