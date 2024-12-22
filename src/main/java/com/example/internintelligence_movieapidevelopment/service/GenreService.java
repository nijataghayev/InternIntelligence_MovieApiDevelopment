package com.example.internintelligence_movieapidevelopment.service;

import com.example.internintelligence_movieapidevelopment.dao.entity.GenreEntity;
import com.example.internintelligence_movieapidevelopment.dao.repository.GenreRepository;
import com.example.internintelligence_movieapidevelopment.mapper.GenreMapper;
import com.example.internintelligence_movieapidevelopment.model.GenreDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: nijataghayev
 */

@Service
@RequiredArgsConstructor
@Slf4j
public class GenreService {
    private final GenreRepository genreRepository;
    private final GenreMapper genreMapper;

    public void addGenre(GenreDto genreDto) {
        log.debug("ActionLog.addGenre.start genre {}", genreDto);
        GenreEntity genreEntity = genreMapper.mapToEntity(genreDto);
        genreRepository.save(genreEntity);
        log.debug("ActionLog.addGenre.end genre {}", genreDto);
    }

    public List<GenreDto> getAllGenres() {
        log.info("ActionLog.getAllGenres.start");
        List<GenreEntity> genreEntityList = genreRepository.findAll();
        List<GenreDto> genreDtos = genreEntityList.stream()
                .map(genreMapper::mapToDto)
                .toList();
        log.info("ActionLog.getAllGenres.end");
        return genreDtos;
    }
}
