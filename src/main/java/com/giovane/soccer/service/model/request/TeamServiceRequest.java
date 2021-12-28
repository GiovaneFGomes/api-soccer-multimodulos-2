package com.giovane.soccer.service.model.request;

import lombok.*;
import java.util.List;
import java.time.LocalDate;
import com.giovane.soccer.entity.player.Player;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class TeamServiceRequest {
    private String id;
    private String name;
    private String icon;
    private String bio;
    private String founded;
    private String stadium;
    private String capacity;
    private String country;
    private String manager;
    private String president;
    private List<Player> player;
    private LocalDate date;
}
