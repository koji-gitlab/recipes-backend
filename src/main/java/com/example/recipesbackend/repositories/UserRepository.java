package com.example.recipesbackend.repositories;

import com.example.recipesbackend.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {

    Optional<User> findByUserName(String userName);

    boolean existsByUserName(String userName);

}
