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

    @NotBlank(message = "Name should not be blank.")
    @Size(max = 100, message = "Max 100 characters.")
    private String name;

    @NotBlank(message = "Icon should not be blank.")
    private String icon;

    @NotBlank(message = "Biography should not be blank.")
    @Size(max = 500, message = "Max 500 characters.")
    private String bio;

    @NotBlank(message = "Founded should not be blank.")
    @Size(max = 100, message = "Max 100 characters.")
    private String founded;

    @NotBlank(message = "Stadium should not be blank.")
    @Size(max = 100, message = "Max 100 characters.")
    private String stadium;

    @NotBlank(message = "Capacity should not be blank.")
    @Size(max = 8, message = "Max 8 characters")
    private String capacity;

    @NotBlank(message = "Country should not be blank.")
    @Size(max = 100, message = "Max 100 characters.")
    private String country;

    @NotBlank(message = "Manager should not be blank.")
    @Size(max = 100, message = "Max 100 characters.")
    private String manager;

    @NotBlank(message = "President should not be blank.")
    @Size(max = 100, message = "Max 100 characters.")
    private String president;

//    @NotEmpty(message = "The list of players should not be empty.")
    private List<Player> player;

//    @NotBlank(message = "Date should not be blank.")
    private LocalDate date;
}
