package com.codecool.krk.gamesapi.game;

import org.springframework.stereotype.Service;

@Service
public class GameServiceImpl implements GameService {

    private GameRepository gameRepository;

    public GameServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public Iterable<Game> findAllGames() {
        Iterable<Game> games = this.gameRepository.findAll();
        return games;
    }

    @Override
    public Game findGameById(Integer id) {
        Game game = this.gameRepository.findOne(id);
        return game;
    }

    @Override
    public void saveGame(Game game) {
        this.gameRepository.save(game);
    }

    @Override
    public void deleteGame(Integer id) {
        this.gameRepository.delete(id);
    }
}
