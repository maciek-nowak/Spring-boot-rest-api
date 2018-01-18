package com.codecool.krk.gamesapi.studio;

import com.codecool.krk.gamesapi.exception.NoSuchIdException;

public interface StudioService {

    Iterable<Studio> findAllStudios();

    Studio findStudioById(Integer id) throws NoSuchIdException;

    void saveStudio(Studio studio);

    void deleteStudio(Integer id) throws NoSuchIdException;

    void updateStudio(Studio studio) throws NoSuchIdException;
}
