package com.example.internintelligence_movieapidevelopment.dao.repository;

import com.example.internintelligence_movieapidevelopment.dao.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: nijataghayev
 */

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByUsername(String username);
}
