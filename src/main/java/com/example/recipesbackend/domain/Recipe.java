package com.example.recipesbackend.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Builder
public class Recipe extends AbstractBaseEntity {

    private String name;

    private String description;

    private Category category;

    private Integer servings;

    @DBRef
    private Set<Ingredient> ingredients = new HashSet<>();

    private List<String> cookingInstructions;

}
