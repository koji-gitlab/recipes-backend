package com.example.recipesbackend.payload.request;

import com.example.recipesbackend.domain.UnitOfMeasure;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class IngredientRequest {

    private String description;

    private BigDecimal amount;

    private UnitOfMeasure uom;

}
