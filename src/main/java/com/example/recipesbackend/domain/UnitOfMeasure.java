package com.example.recipesbackend.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UnitOfMeasure extends AbstractBaseEntity {

    private String description;

}
