package com.codecool.krk.gamesapi.game;

import com.codecool.krk.gamesapi.exception.NoGameToUpdateException;
import com.codecool.krk.gamesapi.exception.NoSuchIdException;
import com.codecool.krk.gamesapi.logger.LoggerCreator;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service
public class GameServiceImplArchive implements GameService {

    private GameRepository gameRepository;
    private LoggerCreator logger;

    public GameServiceImplArchive(GameRepository gameRepository, LoggerCreator logger) {
        this.gameRepository = gameRepository;
        this.logger = logger;
    }

    @Override
    public Iterable<Game> findAllGames() {
        Iterable<Game> games = this.gameRepository.findAllByArchivedIsFalse();
        this.logger.logInfo("Listed all games.");
        return games;
    }

    @Override
    public Game findGameById(Integer id) throws NoSuchIdException {
        Game game = this.gameRepository.findGameByIdAndArchivedIsFalse(id);

        if(game == null) {
            this.logger.logError("ERROR while listing game with wrong id.");
            throw new NoSuchIdException();
        }

        this.logger.logInfo("Listed game with id: " + id);
        return game;
    }

    @Override
    public void saveGame(Game game) {

        game.setId(null);
        this.gameRepository.save(game);
        this.logger.logInfo("Added new game with id: " + game.getId());
    }

    @Override
    public void updateGame(Game game) throws NoGameToUpdateException {
        Integer id = game.getId();

        if (id != null) {
            Game gameInDatabase = this.gameRepository.findGameByIdAndArchivedIsFalse(id);

            if (gameInDatabase == null) {
                this.logger.logError("ERROR while updating game with wrong id.");
                throw new NoGameToUpdateException();
            }
        }

        this.gameRepository.save(game);
        this.logger.logInfo("Updated game with id: " + game.getId());
    }

    @Override
    public void deleteGame(Integer id) throws NoSuchIdException {

        Game game = this.findGameById(id);
        game.setArchived(true);
        this.gameRepository.save(game);
        this.logger.logInfo("Archived game with id: " + game.getId());
    }

}
