package com.example.internintelligence_movieapidevelopment.dao.repository;

import com.example.internintelligence_movieapidevelopment.dao.entity.GenreEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: nijataghayev
 */

public interface GenreRepository extends JpaRepository<GenreEntity, Long> {

    GenreEntity findByName(String name);
}
