package com.example.internintelligence_movieapidevelopment.dao.repository;


import com.example.internintelligence_movieapidevelopment.dao.entity.FilmEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author: nijataghayev
 */

public interface FilmRepository extends JpaRepository<FilmEntity, Long> {

    List<FilmEntity> findByGenreId(Long genreId);

    FilmEntity findByTitle(String title);
}
