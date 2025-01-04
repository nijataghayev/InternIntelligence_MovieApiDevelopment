package com.example.internintelligence_movieapidevelopment.service;

import com.example.internintelligence_movieapidevelopment.dao.entity.UserEntity;
import com.example.internintelligence_movieapidevelopment.dao.repository.UserRepository;
import com.example.internintelligence_movieapidevelopment.exception.NotFoundException;
import com.example.internintelligence_movieapidevelopment.mapper.UserMapper;
import com.example.internintelligence_movieapidevelopment.model.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author: nijataghayev
 */

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public void registerUser(UserDto userDto) {
        log.debug("ActionLog.registerUser.start user {}", userDto);
        UserEntity userEntity = userMapper.mapToEntity(userDto);
        userRepository.save(userEntity);
        log.debug("ActionLog.registerUser.end user {}", userDto);
    }

    public UserDto findUserByUsername(String username) {
        log.info("ActionLog.findUserByUsername.start username{}", username);
        UserEntity userEntity = userRepository.findByUsername(username);
        if (userEntity == null) {
            throw new RuntimeException("User not found with username: " + username);
        }

        UserDto userDto = userMapper.mapToDto(userEntity);
        log.info("ActionLog.findUserByUsername.end username{}", username);
        return userDto;
    }

    public void updateUser(Long userId, UserDto userDto) {
        UserEntity existingUser = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException(
                        "USER_NOT_FOUND",
                        String.format("ActionLog.updateUser.id %s not found", userId)
                ));

        UserEntity updateUser = userMapper.mapToEntity(userDto);
        existingUser.setFirstName(updateUser.getFirstName());
        existingUser.setLastName(updateUser.getLastName());

        userRepository.save(existingUser);
    }

    public void deleteUser(Long userId) {
        log.info("ActionLog.deleteUser.start userId{}", userId);
        UserEntity userEntity = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException(
                        "USER_NOT_FOUND",
                        String.format("ActionLog.deleteUser.id %s not found", userId)
                ));

        userRepository.delete(userEntity);
        log.info("ActionLog.deleteUser.end userId{}", userId);
    }
}
