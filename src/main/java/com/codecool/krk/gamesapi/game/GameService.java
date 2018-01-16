package com.codecool.krk.gamesapi.game;

public interface GameService {

    Iterable<Game> findAllGames();

    Game findGameById(Integer id);

    void saveGame(Game game);

    void deleteGame(Integer id);
}
