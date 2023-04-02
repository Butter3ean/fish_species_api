package com.example.fish_species_api.entities;

import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class ScientificName {

    private String genus;
    private String species;

    public ScientificName() {}

    public ScientificName(String genus, String species) {
        this.genus = genus;
        this.species = species;
    }

    public String getGenus() {
        return this.genus;
    }

    public void setGenus(String genus) {
        this.genus = genus;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScientificName that = (ScientificName) o;
        return genus.equals(that.genus) && species.equals(that.species);
    }

    @Override
    public int hashCode() {
        return Objects.hash(genus, species);
    }

    @Override
    public String toString() {
        return "ScientificName{" +
                "genus='" + genus + '\'' +
                ", species='" + species + '\'' +
                '}';
    }
}
