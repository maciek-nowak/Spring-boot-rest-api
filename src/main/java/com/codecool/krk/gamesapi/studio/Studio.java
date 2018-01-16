package com.codecool.krk.gamesapi.studio;

import com.codecool.krk.gamesapi.game.Game;

import javax.persistence.*;

@Entity
public class Studio {
    private Integer id;
    private String name;
    private Integer localization;
    private Game game;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLocalization() {
        return localization;
    }

    public void setLocalization(Integer localization) {
        this.localization = localization;
    }

    @OneToMany(mappedBy = "studio")
    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
