package pl.sdaacademy.PokemonAcademyApi.pokemon_details.repository;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Other {
    @JsonProperty("official-artwork")
    private OficialArtWork oficialArtWorkList;

    public OficialArtWork getOficialArtWorkList() {
        return oficialArtWorkList;
    }

    public void setOficialArtWorkList(OficialArtWork oficialArtWorkList) {
        this.oficialArtWorkList = oficialArtWorkList;
    }
}
