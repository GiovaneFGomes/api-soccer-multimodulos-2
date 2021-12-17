package com.giovane.soccer.repository.league;

import com.giovane.soccer.entity.league.League;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeagueRepository extends ReactiveMongoRepository<League, String> {

}
