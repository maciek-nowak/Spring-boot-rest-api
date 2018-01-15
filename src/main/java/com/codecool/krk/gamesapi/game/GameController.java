package com.codecool.krk.gamesapi.game;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/games")
public class GameController {

    private GameRepository gameRepository;

    public GameController(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @GetMapping("")
    public Iterable<Game> index() {
        Iterable<Game> games = this.gameRepository.findAll();
        return games;
    }

    @GetMapping(path="/{id}")
    public Game getGame(@PathVariable Integer id) {
        Game game = this.gameRepository.findOne(id);
        return game;
    }

    @PostMapping(path="")
    public Game addGame(@RequestBody Game game) {
        this.gameRepository.save(game);
        return game;
    }

    @ExceptionHandler(Exception.class)
    public  void  handleException(Exception ex) {

    }
}
