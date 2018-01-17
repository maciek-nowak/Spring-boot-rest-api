package com.codecool.krk.gamesapi.studio;

import com.codecool.krk.gamesapi.game.Game;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Studio {
    private Integer id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String localization;
    private Set<Game> games = new HashSet<>();

    @JsonIgnore
    private Boolean archived = false;

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

    public Boolean getArchived() {
        return archived;
    }

    public void setArchived(Boolean archived) {
        this.archived = archived;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocalization() {
        return localization;
    }

    public void setLocalization(String localization) {
        this.localization = localization;
    }

    @OneToMany(mappedBy = "studio", cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JsonIgnoreProperties("studio")
    public Set<Game> getGames() {
        return games;
    }

    public void setGames(Set<Game> games) {
        this.games = games;
    }

}
