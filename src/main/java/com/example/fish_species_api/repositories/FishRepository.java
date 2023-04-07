package com.example.fish_species_api.repositories;

import com.example.fish_species_api.entities.Fish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface FishRepository extends CrudRepository<Fish, Long> {
}
