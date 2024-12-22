package com.example.internintelligence_movieapidevelopment.mapper;

import com.example.internintelligence_movieapidevelopment.dao.entity.UserEntity;
import com.example.internintelligence_movieapidevelopment.model.UserDto;
import org.mapstruct.Mapper;

/**
 * @author: nijataghayev
 */

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserEntity mapToEntity(UserDto userDto);

    UserDto mapToDto (UserEntity userEntity);
}
