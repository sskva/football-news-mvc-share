package com.sskva.footballnewsmvc.repository;

import com.sskva.footballnewsmvc.domain.FootballNew;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface FootballNewRepository extends MongoRepository<FootballNew, String> {


}
