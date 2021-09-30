package com.example.recipesbackend.domain;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class Ingredient extends AbstractBaseEntity {

    private String description;

    private BigDecimal amount;

    private UnitOfMeasure uom;

}
