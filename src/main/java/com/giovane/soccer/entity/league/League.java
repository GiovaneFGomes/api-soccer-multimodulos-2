package com.giovane.soccer.entity.league;

import com.giovane.soccer.entity.team.Team;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Document(collection = "leagues")
public class League {
    private String name;
    private String type;
    private String icon;
    private List<Team> teams;
}
