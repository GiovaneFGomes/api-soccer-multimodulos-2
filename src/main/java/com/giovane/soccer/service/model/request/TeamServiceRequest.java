package com.giovane.soccer.service.model.request;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class TeamServiceRequest {
    private String id;
    private String name;
    private String stadium;
    private String country;
}
