package com.playtech.repository;

import com.playtech.domain.Player;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends MongoRepository<Player, Long> {
    Player findPlayerByPlayerId(Long playerId);

}
