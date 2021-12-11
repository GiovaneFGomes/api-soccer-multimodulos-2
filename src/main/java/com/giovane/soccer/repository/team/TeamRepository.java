package com.giovane.soccer.repository.team;

import com.giovane.soccer.entity.team.Team;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends ReactiveMongoRepository<Team,String> {

}
