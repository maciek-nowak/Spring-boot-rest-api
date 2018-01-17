package com.codecool.krk.gamesapi.studio;

import com.codecool.krk.gamesapi.exception.NoSuchIdException;
import com.codecool.krk.gamesapi.logger.LoggerCreator;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service
public class StudioServiceImplArchive implements StudioService {

    private StudioRepository studioRepository;
    private LoggerCreator logger;

    public StudioServiceImplArchive(StudioRepository studioRepository, LoggerCreator logger) {
        this.studioRepository = studioRepository;
        this.logger = logger;
    }

    @Override
    public Iterable<Studio> findAllStudios() {
        Iterable<Studio> studios = this.studioRepository.findAll();
        this.logger.logInfo("Listed all studios.");
        return studios;
    }

    @Override
    public Studio findStudioById(Integer id) throws NoSuchIdException {
        Studio studio = this.studioRepository.findOne(id);

        if(studio == null) {
            throw new NoSuchIdException();
        }

        this.logger.logError("Listed some studio.");
        return studio;
    }

    @Override
    public void saveStudio(Studio studio) {
        Integer id = studio.getId();

        if (id != null) {
            Studio studioInDatabase = this.studioRepository.findOne(id);

            if (studioInDatabase != null) {
                studio.setId(null);
            }
        }

        this.studioRepository.save(studio);
    }

    @Override
    public void deleteStudio(Integer id) throws NoSuchIdException {
        this.findStudioById(id);

        this.studioRepository.delete(id);
    }

    @Override
    public void updateStudio(Studio studio) {
        this.studioRepository.save(studio);
    }
}
