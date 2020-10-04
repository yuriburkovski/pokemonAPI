package pl.sdaacademy.PokemonAcademyApi.pokemon_details.repository;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OficialArtWork {
    @JsonProperty("front_default")
    private String imageUrl;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
