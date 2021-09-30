package com.example.recipesbackend.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Ingredient extends AbstractBaseEntity {

    private String description;

    private BigDecimal amount;

    private UnitOfMeasure uom;

}
