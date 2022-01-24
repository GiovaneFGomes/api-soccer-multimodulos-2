package com.giovane.soccer.service.model.response;

import com.giovane.soccer.entity.player.Player;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class TeamServiceResponse {
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
