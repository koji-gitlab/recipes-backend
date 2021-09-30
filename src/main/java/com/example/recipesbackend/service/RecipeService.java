package com.example.recipesbackend.service;

import com.example.recipesbackend.domain.Recipe;
import com.example.recipesbackend.repositories.IngredientRepository;
import com.example.recipesbackend.repositories.RecipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;

    private final IngredientRepository ingredientRepository;

    public List<Recipe> findAll() {
        return recipeRepository.findAll();
    }

    @Transactional
    public Recipe add(Recipe recipe) {
        if (! CollectionUtils.isEmpty(recipe.getIngredients()))
            recipe.setIngredients(recipe.getIngredients().stream().map(ingredientRepository::save).collect(Collectors.toSet()));
        return recipeRepository.save(recipe);
    }

    public Recipe update(String id, Recipe recipe) {
        Recipe oldRecipe = recipeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Can't found recipe by ID %s", id)));
        BeanUtils.copyProperties(recipe, oldRecipe, "id", "ingredients");
        oldRecipe.getIngredients().clear();
        if (! CollectionUtils.isEmpty(recipe.getIngredients())) {
            oldRecipe.setIngredients(recipe.getIngredients().stream().map(ingredientRepository::save).collect(Collectors.toSet()));
        }
        return recipeRepository.save(oldRecipe);
    }

    public void delete(String id) {
        recipeRepository.delete(recipeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Can't found recipe by ID %s", id))));
    }

}
