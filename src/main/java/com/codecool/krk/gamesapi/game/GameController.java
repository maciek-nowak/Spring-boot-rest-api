package com.codecool.krk.gamesapi.game;

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
    public Game getGame(@PathVariable Integer id) {
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

    @ExceptionHandler(Exception.class)
    public  void  handleException(Exception ex) {

    }
}
