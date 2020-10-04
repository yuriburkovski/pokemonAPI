package pl.sdaacademy.PokemonAcademyApi.pokemon_details.repository.pokeapi.image;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Sprites {
    @JsonProperty("other")
    private Other otherList;

    public Other getOtherList() {
        return otherList;
    }

    public void setOtherList(Other otherList) {
        this.otherList = otherList;
    }
}
