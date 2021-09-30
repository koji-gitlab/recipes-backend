package com.example.recipesbackend.payload.request;

import com.example.recipesbackend.domain.Category;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
public class RecipeRequest {

    @NotBlank
    private String name;

    private String description;

    private Category category;

    private Integer servings;

    private List<IngredientRequest> ingredients;

    private List<String> cookingInstructions;

}
