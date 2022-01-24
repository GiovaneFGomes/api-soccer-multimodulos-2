package com.giovane.soccer.service.model.request;

import com.giovane.soccer.entity.player.Player;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

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
