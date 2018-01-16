package com.codecool.krk.gamesapi.studio;

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
    public Studio findStudioById(Integer id) {
        Studio studio = this.studioRepository.findOne(id);
        return studio;
    }

    @Override
    public void saveStudio(Studio studio) {
        this.studioRepository.save(studio);
    }

    @Override
    public void deleteStudio(Integer id) {
        this.studioRepository.delete(id);
    }
}
