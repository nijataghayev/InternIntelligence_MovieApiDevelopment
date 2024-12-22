package com.example.internintelligence_movieapidevelopment.mapper;

import com.example.internintelligence_movieapidevelopment.dao.entity.FilmEntity;
import com.example.internintelligence_movieapidevelopment.model.FilmDto;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author: nijataghayev
 */

@Mapper(componentModel = "spring")
public interface FilmMapper {

    FilmEntity mapToEntity(FilmDto filmDto);

    FilmDto mapToDto(FilmEntity filmEntity);

    List<FilmDto> mapToDtos(List<FilmEntity> filmEntities);
}
