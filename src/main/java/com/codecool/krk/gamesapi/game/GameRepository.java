package com.codecool.krk.gamesapi.game;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends CrudRepository<Game, Integer> {

    Iterable<Game> findAllByArchivedIsFalse();

    Game findGameByIdAndArchivedIsFalse(Integer Id);
}
