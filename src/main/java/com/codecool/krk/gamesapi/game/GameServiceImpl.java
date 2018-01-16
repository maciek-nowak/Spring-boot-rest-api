package com.codecool.krk.gamesapi.game;

import com.codecool.krk.gamesapi.exception.NoSuchIdException;
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
    public Game findGameById(Integer id) throws NoSuchIdException {
        Game game = this.gameRepository.findOne(id);

        if(game == null) {
            throw new NoSuchIdException();
        }

        return game;
    }

    @Override
    public void saveGame(Game game) {
        this.gameRepository.save(game);
    }

    @Override
    public void deleteGame(Integer id) throws NoSuchIdException {

        this.findGameById(id);

        this.gameRepository.delete(id);
    }
}
