package com.example.recipesbackend.repositories;

import com.example.recipesbackend.domain.Recipe;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RecipeRepository extends MongoRepository<Recipe, String> {
}
