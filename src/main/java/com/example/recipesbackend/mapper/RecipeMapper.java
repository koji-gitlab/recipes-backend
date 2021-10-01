package com.example.recipesbackend.mapper;

import com.example.recipesbackend.domain.Ingredient;
import com.example.recipesbackend.domain.Recipe;
import com.example.recipesbackend.payload.request.RecipeRequest;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = {IngredientMapper.class})
public interface RecipeMapper {

    Recipe toEntity(RecipeRequest dto);

    RecipeRequest toDto(Recipe entity);

}
