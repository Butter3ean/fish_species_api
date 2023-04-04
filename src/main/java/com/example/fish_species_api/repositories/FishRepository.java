package com.example.fish_species_api.repositories;

import com.example.fish_species_api.entities.Fish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FishRepository extends JpaRepository<Fish, Long> {
}
