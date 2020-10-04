package pl.sdaacademy.PokemonAcademyApi.pokemon_details.repository;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

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
