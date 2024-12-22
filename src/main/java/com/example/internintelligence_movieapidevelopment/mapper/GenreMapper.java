package com.example.internintelligence_movieapidevelopment.mapper;

import com.example.internintelligence_movieapidevelopment.dao.entity.GenreEntity;
import com.example.internintelligence_movieapidevelopment.model.GenreDto;
import org.mapstruct.Mapper;

/**
 * @author: nijataghayev
 */

@Mapper(componentModel = "spring")
public interface GenreMapper {

    GenreEntity mapToEntity(GenreDto genreDto);

    GenreDto mapToDto(GenreEntity genreEntity);
}
