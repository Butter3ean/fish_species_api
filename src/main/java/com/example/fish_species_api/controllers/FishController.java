package com.example.fish_species_api.controllers;

import com.example.fish_species_api.entities.Fish;
import com.example.fish_species_api.repositories.FishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fish-species")
public class FishController {

    @Autowired
    private FishRepository repository;

    //Gets all fish in the database
    //GET http://localhost:8080/fish-species
    @GetMapping
    public List<Fish> getAllFish() {
        return repository.findAll();
    }

    //Gets a fish with a specific id
    //GET http://localhost:8080/fish-species/id
    @GetMapping("/{id}")
    public Fish findById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow();
    }

    //adds a fish to the database
    //POST http://localhost:8080/fish-species
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Fish addFish(@RequestBody Fish newFish) {
        return repository.save(newFish);
    }

    //updates a fish in the database
    //POST http://localhost:8080/fish-species/id
    @PutMapping("/{id}")
    public Fish updateFish(@RequestBody Fish newFish, @PathVariable Long id) {
        return repository.findById(id)
                .map(fish -> {
                  fish.setScientificName(newFish.getScientificName());
                  fish.setCommonName(newFish.getCommonName());
                  fish.setDescription(newFish.getDescription());
                  fish.setImageUrl(newFish.getImageUrl());
                  fish.setOtherNames(newFish.getOtherNames());
                  return repository.save(fish);
                })
                .orElseGet(() -> {
                    newFish.setId(id);
                    return repository.save(newFish);
                });
    }

    //deletes a fish with a specified id from the database
    //DELETE http://localhost:8080/fish-species/id
    @DeleteMapping("/{id}")
    public void deleteFish(@PathVariable Long id) { repository.deleteById(id); }
}
