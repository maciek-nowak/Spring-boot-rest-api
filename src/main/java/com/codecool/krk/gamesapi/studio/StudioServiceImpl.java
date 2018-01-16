package com.codecool.krk.gamesapi.studio;

import com.codecool.krk.gamesapi.exception.NoSuchIdException;
import org.springframework.stereotype.Service;

@Service
public class StudioServiceImpl implements StudioService {

    private StudioRepository studioRepository;

    public StudioServiceImpl(StudioRepository studioRepository) {
        this.studioRepository = studioRepository;
    }

    @Override
    public Iterable<Studio> findAllStudios() {
        Iterable<Studio> studios = this.studioRepository.findAll();
        return studios;
    }

    @Override
    public Studio findStudioById(Integer id) throws NoSuchIdException {
        Studio studio = this.studioRepository.findOne(id);

        if(studio == null) {
            throw new NoSuchIdException();
        }

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
