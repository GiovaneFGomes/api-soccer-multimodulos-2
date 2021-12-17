package com.giovane.soccer.service.model.request;

import com.giovane.soccer.entity.player.Player;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class TeamServiceRequest {
    private String id;
    private String name;
    private String stadium;
    private String icon;
    private String bio;
    private String country;
    private List<Player> player;
    private LocalDate date;
}
