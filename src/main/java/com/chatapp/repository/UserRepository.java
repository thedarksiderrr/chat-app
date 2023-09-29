package com.chatapp.repository;

import com.chatapp.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    //loading user from database by username
    Optional<UserEntity> findByEmail(String email);

    //loading user from database by username
    UserEntity getUserByUserName(String userName);
}
