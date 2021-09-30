package com.example.recipesbackend.mapper;

import com.example.recipesbackend.domain.Ingredient;
import com.example.recipesbackend.payload.request.IngredientRequest;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IngredientMapper {

    Ingredient toEntity(IngredientRequest dto);

}
