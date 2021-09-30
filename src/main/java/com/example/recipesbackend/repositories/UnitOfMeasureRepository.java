package com.example.recipesbackend.repositories;

import com.example.recipesbackend.domain.UnitOfMeasure;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UnitOfMeasureRepository extends MongoRepository<UnitOfMeasure, String> {
}
