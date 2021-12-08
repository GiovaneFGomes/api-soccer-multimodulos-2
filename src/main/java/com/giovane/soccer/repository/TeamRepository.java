package com.giovane.soccer.repository;

import com.giovane.soccer.entity.Team;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface TeamRepository extends ReactiveMongoRepository<Team,String> {

}
