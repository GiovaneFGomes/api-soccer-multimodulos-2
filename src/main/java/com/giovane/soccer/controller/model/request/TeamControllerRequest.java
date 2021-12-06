package com.giovane.soccer.controller.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class TeamControllerRequest {
    private String id;
    private String name;
    private String stadium;
    private String country;
}
