package com.example.fish_species_api.entities;

import jakarta.persistence.*;

import java.net.URI;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "fish")
public class Fish {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Embedded
    private ScientificName scientificName;
    private String commonName;
    private List<String> otherNames;
    private String desc;
    private URI imageUrl;

    public Fish() {}

    public Fish(ScientificName scientificName, String commonName, List<String> otherNames, String desc, URI imageUrl) {
        this.scientificName = scientificName;
        this.commonName = commonName;
        this.otherNames = otherNames;
        this.desc = desc;
        this.imageUrl = imageUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ScientificName getScientificName() {
        return scientificName;
    }

    public void setScientificName(ScientificName scientificName) {
        this.scientificName = scientificName;
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public List<String> getOtherNames() {
        return otherNames;
    }

    public void setOtherNames(List<String> otherNames) {
        this.otherNames = otherNames;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public URI getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(URI imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fish fish = (Fish) o;
        return id.equals(fish.id) && scientificName.equals(fish.scientificName) && commonName.equals(fish.commonName) && otherNames.equals(fish.otherNames) && desc.equals(fish.desc) && imageUrl.equals(fish.imageUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, scientificName, commonName, otherNames, desc, imageUrl);
    }

    @Override
    public String toString() {
        return "Fish{" +
                "id=" + id +
                ", scientificName=" + scientificName +
                ", commonName='" + commonName + '\'' +
                ", otherNames=" + otherNames +
                ", desc='" + desc + '\'' +
                ", imageUrl=" + imageUrl +
                '}';
    }
}
