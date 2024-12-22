package com.example.internintelligence_movieapidevelopment.service;

import com.example.internintelligence_movieapidevelopment.dao.entity.FilmEntity;
import com.example.internintelligence_movieapidevelopment.dao.repository.FilmRepository;
import com.example.internintelligence_movieapidevelopment.mapper.FilmMapper;
import com.example.internintelligence_movieapidevelopment.model.FilmDto;
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
public class FilmService {
    private final FilmRepository filmRepository;
    private final FilmMapper filmMapper;

    public void addFilm(FilmDto filmDto) {
        log.debug("ActionLog.addFilm.start film {}", filmDto);
        FilmEntity filmEntity = filmMapper.mapToEntity(filmDto);
        filmRepository.save(filmEntity);
        log.debug("ActionLog.addFilms.end film {}", filmDto);
    }

    public List<FilmDto> getFilmsByGenre(Long genreId) {
        log.info("ActionLog.getFilmsByGenre.start genreId{}", genreId);
        List<FilmEntity> filmEntities = filmRepository.findByGenreId(genreId);
        List<FilmDto> films = filmMapper.mapToDtos(filmEntities);

        log.info("ActionLog.getFilmsByGenre.end genreId{}", genreId);
        return films;
    }

    public FilmDto findByTitle(String title) {
        log.info("ActionLog.findByTitle.start title {}", title);
        FilmEntity filmEntity = filmRepository.findByTitle(title);
        if (filmEntity == null) {
            throw new RuntimeException("Film not found with " + title);
        }

        FilmDto film = filmMapper.mapToDto(filmEntity);
        log.info("ActionLog.findByTitle.start title {}", title);
        return film;
    }
}
