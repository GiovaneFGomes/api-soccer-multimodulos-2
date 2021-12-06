package com.giovane.soccer.controller.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class TeamControllerResponse {
    private String id;
    private String name;
    private String stadium;
    private String country;
}
