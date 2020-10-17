package pl.sdaacademy.PokemonAcademyApi.pokemon_list_item.repository;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Images {

    @JsonProperty("front_default")
    private String frontDefault;

    public String getFrontDefault() {
        return frontDefault;
    }
}
