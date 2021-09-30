package com.example.recipesbackend.repositories;

import com.example.recipesbackend.domain.Ingredient;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IngredientRepository extends MongoRepository<Ingredient, String> {
}
