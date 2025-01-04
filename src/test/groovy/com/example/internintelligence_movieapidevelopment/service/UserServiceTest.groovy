package com.example.internintelligence_movieapidevelopment.service

import com.example.internintelligence_movieapidevelopment.dao.entity.UserEntity
import com.example.internintelligence_movieapidevelopment.dao.repository.UserRepository
import com.example.internintelligence_movieapidevelopment.mapper.UserMapper
import com.example.internintelligence_movieapidevelopment.model.UserDto
import io.github.benas.randombeans.EnhancedRandomBuilder
import io.github.benas.randombeans.api.EnhancedRandom
import spock.lang.Specification

/**
 * @author: nijataghayev
 */

class UserServiceTest extends Specification {
    private UserService userService
    private UserRepository userRepository
    private UserMapper userMapper
    private EnhancedRandom random

    void setup() {
        random = EnhancedRandomBuilder.aNewEnhancedRandomBuilder().build()
        userRepository = Mock()
        userMapper = Mock()
        userService = new UserService(userRepository, userMapper)
    }

    def "RegisterUser"() {
        given:
        def userDto = random.nextObject(UserDto)
        def userEntity = random.nextObject(UserEntity)

        when:
        userService.registerUser(userDto)

        then:
        1 * userMapper.mapToEntity(userDto) >> userEntity
        1 * userRepository.save(userEntity)
    }

    def "FindUserByUsername"() {
        given:
        def userName = "testUser"
        def userEntity = random.nextObject(UserEntity)
        def userDto = random.nextObject(UserDto)

        when:
        def result = userService.findUserByUsername(userName)

        then:
        1 * userRepository.findByUsername(userName) >> userEntity
        1 * userMapper.mapToDto(userEntity) >> userDto
        result == userDto
    }

    def "FindUserByUsername throws RuntimeException when user not found"() {
        given:
        def username = "nonExistingUser"

        when:
        userService.findUserByUsername(username)

        then:
        1 * userRepository.findByUsername(username) >> null
        thrown(RuntimeException)
    }

    def "UpdateUser"() {
        given:
        def userId = 1L
        def userDto = random.nextObject(UserDto)
        def existingUser = random.nextObject(UserEntity)
        def updateUser = random.nextObject(UserEntity)

        when:
        userService.updateUser(userId, userDto)

        then:
        1 * userRepository.findById(userId) >> Optional.of(existingUser)
        1 * userMapper.mapToEntity(userDto) >> updateUser
        1 * userRepository.save(existingUser)
    }

    def "DeleteUser"() {
        given:
        def userId = 1L
        def userEntity = random.nextObject(UserEntity)

        when:
        userService.deleteUser(userId)

        then:
        1 * userRepository.findById(userId) >> Optional.of(userEntity)
        1 * userRepository.delete(userEntity)
    }
}
