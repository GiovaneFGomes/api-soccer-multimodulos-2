package com.giovane.soccer.controller.model.response;

import lombok.*;
import java.util.List;
import java.time.LocalDate;
import com.giovane.soccer.entity.player.Player;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class TeamControllerResponse {
    private String id;
    private String name;
    private String stadium;
    private String country;
    private List<Player> player;
    private LocalDate date;
}
