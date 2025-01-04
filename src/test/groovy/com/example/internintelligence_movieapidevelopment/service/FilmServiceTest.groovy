package com.example.internintelligence_movieapidevelopment.service

import com.example.internintelligence_movieapidevelopment.dao.entity.FilmEntity
import com.example.internintelligence_movieapidevelopment.dao.repository.FilmRepository
import com.example.internintelligence_movieapidevelopment.mapper.FilmMapper
import com.example.internintelligence_movieapidevelopment.model.FilmDto
import io.github.benas.randombeans.EnhancedRandomBuilder
import io.github.benas.randombeans.api.EnhancedRandom
import spock.lang.Specification

/**
 * @author: nijataghayev
 */

class FilmServiceTest extends Specification {
    private FilmService filmService
    private FilmRepository filmRepository
    private FilmMapper filmMapper
    private EnhancedRandom random

    void setup() {
        random = EnhancedRandomBuilder.aNewEnhancedRandomBuilder().build()
        filmRepository = Mock()
        filmMapper = Mock()
        filmService = new FilmService(filmRepository, filmMapper)
    }

    def "AddFilm"() {
        given:
        def filmDto = random.nextObject(FilmDto)
        def filmEntity = random.nextObject(FilmEntity)

        when:
        filmService.addFilm(filmDto)

        then:
        1 * filmMapper.mapToEntity(filmDto) >> filmEntity
        1 * filmRepository.save(filmEntity)
    }

    def "GetFilmsByGenre"() {
        given:
        def genreId = 1L
        def filmEntities = random.objects(FilmEntity, 2).toList()
        def films = filmEntities.collect() { random.nextObject(FilmDto) }

        when:
        def result = filmService.getFilmsByGenre(genreId)

        then:
        1 * filmRepository.findByGenreId(genreId) >> filmEntities
        1 * filmMapper.mapToDtos(filmEntities) >> films

        result.size() == films.size()
        result == films
    }

    def "FindByTitle"() {
        given:
        def title = "TestTitle"
        def filmEntity = random.nextObject(FilmEntity)
        def filmDto = random.nextObject(FilmDto)

        when:
        def result = filmService.findByTitle(title)

        then:
        1 * filmRepository.findByTitle(title) >> filmEntity
        1 * filmMapper.mapToDto(filmEntity) >> filmDto

        result == filmDto
    }

    def "FindByTitle throws RuntimeException when film not found"() {
        given:
        def title = "NonExistingFilm"

        when:
        filmService.findByTitle(title)

        then:
        1 * filmRepository.findByTitle(title) >> null
        thrown(RuntimeException)
    }
}
