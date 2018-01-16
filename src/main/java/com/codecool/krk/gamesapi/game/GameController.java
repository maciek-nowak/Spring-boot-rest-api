package com.codecool.krk.gamesapi.game;

import com.codecool.krk.gamesapi.exception.NoSuchIdException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/games")
public class GameController {

    private GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("")
    public Iterable<Game> getAllGames() {
        Iterable<Game> games = this.gameService.findAllGames();
        return games;
    }

    @GetMapping("/{id}")
    public Game getGame(@PathVariable Integer id) throws NoSuchIdException {
        Game game = this.gameService.findGameById(id);
        return game;
    }

    @PostMapping("")
    public Game addGame(@RequestBody Game game) {
        this.gameService.saveGame(game);
        return game;
    }

    @DeleteMapping("/{id}")
    public void deleteGame(@PathVariable Integer id) {
        this.gameService.deleteGame(id);
    }

    @PutMapping("")
    public Game updateGame(@RequestBody Game game) {
        this.gameService.saveGame(game);
        return game;
    }

}
