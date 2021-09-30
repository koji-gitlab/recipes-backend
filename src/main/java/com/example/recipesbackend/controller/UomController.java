package com.example.recipesbackend.controller;

import com.example.recipesbackend.domain.UnitOfMeasure;
import com.example.recipesbackend.repositories.UnitOfMeasureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/uom")
public class UomController {

    private final UnitOfMeasureRepository unitOfMeasureRepository;

    @GetMapping
    public List<UnitOfMeasure> getAll() {
        return unitOfMeasureRepository.findAll();
    }

}
