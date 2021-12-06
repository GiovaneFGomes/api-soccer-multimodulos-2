package com.giovane.soccer.service.model.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class TeamServiceResponse {
    private String id;
    private String name;
    private String stadium;
    private String country;
}
