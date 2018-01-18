package com.codecool.krk.gamesapi.game;

import com.codecool.krk.gamesapi.studio.Studio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface GameRepository extends CrudRepository<Game, Integer> {

    Iterable<Game> findAllByArchivedIsFalse();

    Set<Game> findAllByStudioAndArchivedIsFalse(Studio studio);

    Game findGameByIdAndArchivedIsFalse(Integer Id);
}
