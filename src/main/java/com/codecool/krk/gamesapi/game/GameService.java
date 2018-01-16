package com.codecool.krk.gamesapi.game;

import com.codecool.krk.gamesapi.exception.NoSuchIdException;

public interface GameService {

    Iterable<Game> findAllGames();

    Game findGameById(Integer id) throws NoSuchIdException;

    void saveGame(Game game);

    void deleteGame(Integer id) throws NoSuchIdException;
}
