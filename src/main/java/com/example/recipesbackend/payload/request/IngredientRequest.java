package com.example.recipesbackend.payload.request;

import com.example.recipesbackend.domain.UnitOfMeasure;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class IngredientRequest {

    private String description;

    private BigDecimal amount;

    private UnitOfMeasure uom;

}
