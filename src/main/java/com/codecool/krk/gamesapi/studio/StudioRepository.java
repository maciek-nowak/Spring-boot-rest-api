package com.codecool.krk.gamesapi.studio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudioRepository  extends CrudRepository<Studio, Integer> {
}
