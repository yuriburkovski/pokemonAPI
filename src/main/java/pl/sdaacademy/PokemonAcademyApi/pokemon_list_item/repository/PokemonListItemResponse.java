package pl.sdaacademy.PokemonAcademyApi.pokemon_list_item.repository;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PokemonListItemResponse {
    @JsonProperty("base_experience")
    private int baseExperience;

    private String name;

    @JsonProperty("sprites")
    private Images images;

    public int getBaseExperience() {
        return baseExperience;
    }

    public String getName() {
        return name;
    }

    public Images getImages() {
        return images;
    }
}
