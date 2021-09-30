package com.example.recipesbackend.controller;

import com.example.recipesbackend.domain.Recipe;
import com.example.recipesbackend.mapper.RecipeMapper;
import com.example.recipesbackend.payload.request.RecipeRequest;
import com.example.recipesbackend.service.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/recipe")
public class RecipeController {

    private final RecipeService recipeService;

    private final RecipeMapper recipeMapper;

    @GetMapping
    public List<Recipe> getAll() {
        return recipeService.findAll();
    }

    @PostMapping
    public Recipe create(@Valid @RequestBody RecipeRequest recipeRequest) {
        return recipeService.add(recipeMapper.toEntity(recipeRequest));
    }

    @PutMapping("/{id}")
    public Recipe update(@PathVariable String id,
                         @Valid @RequestBody RecipeRequest recipeRequest) {
        return recipeService.update(id, recipeMapper.toEntity(recipeRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable String id) {
        recipeService.delete(id);
        return ResponseEntity.ok(Collections.singletonMap("message", "Recipe has been deleted"));
    }

}
