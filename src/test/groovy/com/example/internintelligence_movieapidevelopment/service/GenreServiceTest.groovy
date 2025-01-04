package com.example.internintelligence_movieapidevelopment.service

import com.example.internintelligence_movieapidevelopment.dao.entity.GenreEntity
import com.example.internintelligence_movieapidevelopment.dao.repository.GenreRepository
import com.example.internintelligence_movieapidevelopment.mapper.GenreMapper
import com.example.internintelligence_movieapidevelopment.model.GenreDto
import io.github.benas.randombeans.EnhancedRandomBuilder
import io.github.benas.randombeans.api.EnhancedRandom
import spock.lang.Specification

/**
 * @author: nijataghayev
 */

class GenreServiceTest extends Specification {
    private GenreService genreService
    private GenreRepository genreRepository
    private GenreMapper genreMapper
    private EnhancedRandom random

    void setup() {
        random = EnhancedRandomBuilder.aNewEnhancedRandomBuilder().build()
        genreRepository = Mock()
        genreMapper = Mock()
        genreService = new GenreService(genreRepository, genreMapper)
    }

    def "AddGenre"() {
        given:
        def genreDto = random.nextObject(GenreDto)
        def genreEntity = random.nextObject(GenreEntity)

        when:
        genreService.addGenre(genreDto)

        then:
        1 * genreMapper.mapToEntity(genreDto) >> genreEntity
        1 * genreRepository.save(genreEntity)
    }

    def "GetAllGenres"() {
        given:
        def genreEntityList = random.objects(GenreEntity, 5).toList()
        def genreDtos = genreEntityList.collect { random.nextObject(GenreDto) }
        genreRepository.findAll() >> genreEntityList
        genreEntityList.eachWithIndex { entity, i ->
            genreMapper.mapToDto(entity) >> genreDtos[i]
        }

        when:
        def result = genreService.getAllGenres()

        then:
        result.size() == genreDtos.size()
        result == genreDtos
    }
}
