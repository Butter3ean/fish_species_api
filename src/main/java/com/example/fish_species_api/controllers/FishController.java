package com.example.fish_species_api.controllers;

import com.example.fish_species_api.entities.Fish;
import com.example.fish_species_api.repositories.FishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fishspecies")
public class FishController {

    @Autowired
    private FishRepository repository;

    @GetMapping()
    public List<Fish> getAllFish() {
        return repository.findAll();
    }

    @PostMapping()
    public Fish addFish(@RequestParam Fish newFish) {
        return repository.save(newFish);
    }
}
