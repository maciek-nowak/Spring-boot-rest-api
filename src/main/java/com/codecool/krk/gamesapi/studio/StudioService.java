package com.codecool.krk.gamesapi.studio;

public interface StudioService {

    Iterable<Studio> findAllStudios();

    Studio findStudioById(Integer id);

    void saveStudio(Studio studio);

    void deleteStudio(Integer id);
}
