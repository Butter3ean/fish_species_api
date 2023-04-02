package com.example.fish_species_api.entities;

import jakarta.persistence.*;

import java.net.URI;
import java.util.List;

@Entity
public class Fish {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Embedded
    private ScientificName scientificName;
    private String commonName;
    private List<String> otherNames;
    private String desc;
    private URI imageUrl;


}
